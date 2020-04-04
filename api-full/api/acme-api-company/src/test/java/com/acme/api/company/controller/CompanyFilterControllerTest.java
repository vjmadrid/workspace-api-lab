package com.acme.api.company.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.acme.api.company.constant.CompanyControllerConstant;
import com.acme.api.company.service.CompanyService;
import com.acme.model.api.company.entity.CompanyResponse;
import com.acme.model.api.company.factory.dummy.DummyCompanyResponseDataFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CompanyFilterController.class)
public class CompanyFilterControllerTest {

	private static final String ID_FILTER = "3,po,2";

	private List<CompanyResponse> COMPANY_RESPONSE_LIST = DummyCompanyResponseDataFactory.createSampleDefaultList();

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CompanyService companyService;

	@MockBean
	private CompanyPagingController companyPagingController;

	private ObjectMapper mapper = new ObjectMapper();

	@BeforeEach
	public void init() {
		when(companyService.findByPKList(anyList())).thenReturn(COMPANY_RESPONSE_LIST);
	}

	// Find by id filter
	@Test
	public void whenCallAPIGetByIdList_ThenRetrieveListNotFound() throws Exception {
		when(companyService.findByPKList(anyList())).thenReturn(Collections.emptyList());

		mockMvc.perform(get(CompanyControllerConstant.BASE_FILTER_URL + CompanyControllerConstant.BASE_FILTER_LIST_URL)
				.param(CompanyControllerConstant.URL_VAR_ID_LIST, ID_FILTER)).andExpect(status().isNoContent());
	}

	@Test
	public void whenCallAPIGetByIdList_ThenRetrieveAllElements() throws Exception {
		MvcResult result = mockMvc
				.perform(get(CompanyControllerConstant.BASE_FILTER_URL + CompanyControllerConstant.BASE_FILTER_LIST_URL)
						.param(CompanyControllerConstant.URL_VAR_ID_LIST, ID_FILTER))
				.andExpect(status().isOk()).andReturn();

		List<CompanyResponse> response = mapper.readValue(result.getResponse().getContentAsByteArray(),
				new TypeReference<List<CompanyResponse>>() {
				});

		assertEquals(COMPANY_RESPONSE_LIST, response);
	}

}