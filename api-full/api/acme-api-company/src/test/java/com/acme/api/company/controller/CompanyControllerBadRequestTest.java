package com.acme.api.company.controller;

import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.acme.api.company.constant.CompanyControllerConstant;
import com.acme.api.company.service.CompanyPagingService;
import com.acme.api.company.service.CompanyService;
import com.acme.architecture.common.util.RestUtil;
import com.acme.model.api.company.entity.CompanyRequest;
import com.acme.model.api.company.entity.CompanyResponse;
import com.acme.model.api.company.factory.dummy.DummyCompanyRequestDataFactory;
import com.acme.model.api.company.factory.dummy.DummyCompanyResponseDataFactory;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CompanyController.class)
public class CompanyControllerBadRequestTest {
	
	private static final String USER_ID = "3";

	private List<CompanyResponse> COMPANY_RESPONSE_LIST = DummyCompanyResponseDataFactory.createSampleDefaultList();

	private CompanyResponse COMPANY_RESPONSE = DummyCompanyResponseDataFactory.createSampleDefault();

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CompanyService companyService;

	@MockBean
	private CompanyPagingService companyPagingService;

	private Map<String, List<Object>> badRequestMap;

	@BeforeEach
	public void init() {

		when(companyService.findAll()).thenReturn(COMPANY_RESPONSE_LIST);
		when(companyService.findByPK(any())).thenReturn(Optional.of(COMPANY_RESPONSE));
		when(companyService.existByPK(any())).thenReturn(true);
		when(companyService.create(any(), Mockito.isNull())).thenReturn(COMPANY_RESPONSE);
		when(companyService.update(any(), any(), Mockito.isNull())).thenReturn(Optional.of(COMPANY_RESPONSE));

		badRequestMap = loadBadRequestMap();
	}

	// Update
	@Test
	public void whenCallAPIUpdate_thenRetrievebadRequest() throws Exception {

		badRequestMap.forEach((field, restrictionList) -> {

			restrictionList.forEach(restriction -> {

				try {

					CompanyRequest companyRequest = DummyCompanyRequestDataFactory.createSampleDefault();
					changeFieldValue(companyRequest, field, restriction);

					mockMvc.perform(
							put(CompanyControllerConstant.BASE_URL + CompanyControllerConstant.UPDATE_PATH, USER_ID)
									.contentType(MediaType.APPLICATION_JSON)
									.content(RestUtil.covertToJsonResponse(companyRequest)))
							.andExpect(status().isBadRequest());

				} catch (Exception e) {
					fail(e.toString());
				}
			});
		});
	}

	// Insert
	@Test
	public void whenCallAPICreate_thenRetrieveBadRequest() {

		badRequestMap.forEach((field, restrictionList) -> {

			restrictionList.forEach(restriction -> {

				try {

					CompanyRequest companyRequest = DummyCompanyRequestDataFactory.createSampleDefault();
					changeFieldValue(companyRequest, field, restriction);

					mockMvc.perform(post(CompanyControllerConstant.BASE_URL).contentType(MediaType.APPLICATION_JSON)
							.content(RestUtil.covertToJsonResponse(companyRequest)))
							.andExpect(status().isBadRequest());

				} catch (Exception e) {
					fail(e.toString());
				}
			});
		});
	}

	private Map<String, List<Object>> loadBadRequestMap() {

		Map<String, List<Object>> badRequestMap = new HashMap<>();

		List<Object> companyNameRestrictions = new ArrayList<>();
		companyNameRestrictions.add(null);
		companyNameRestrictions.add("");
		companyNameRestrictions.add(StringUtils.repeat('z', 51));

		badRequestMap.put("companyName", companyNameRestrictions);

		return badRequestMap;
	}

	private void changeFieldValue(Object instance, String fieldName, Object fieldValue)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

		Class<?> c = instance.getClass();
		Field chap = c.getDeclaredField(fieldName);
		chap.setAccessible(true);
		chap.set(instance, fieldValue);

	}

}
