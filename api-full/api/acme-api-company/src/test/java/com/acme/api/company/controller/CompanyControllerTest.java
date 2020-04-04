package com.acme.api.company.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
import org.springframework.test.web.servlet.MvcResult;

import com.acme.api.company.constant.CompanyControllerConstant;
import com.acme.api.company.service.CompanyPagingService;
import com.acme.api.company.service.CompanyService;
import com.acme.architecture.common.util.RestUtil;
import com.acme.model.api.company.entity.CompanyRequest;
import com.acme.model.api.company.entity.CompanyResponse;
import com.acme.model.api.company.factory.dummy.DummyCompanyResponseDataFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class CompanyControllerTest {

	private static final String COMPANY_ID = "3";

	private List<CompanyResponse> COMPANY_RESPONSE_LIST = DummyCompanyResponseDataFactory.createSampleDefaultList();

	private CompanyResponse COMPANY_RESPONSE = DummyCompanyResponseDataFactory.createSampleDefault();

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CompanyService companyService;

	@MockBean
	private CompanyPagingService companyPagingService;

	private ObjectMapper mapper = new ObjectMapper();

	@BeforeEach
	public void init() {

		when(companyService.findAll()).thenReturn(COMPANY_RESPONSE_LIST);
		when(companyService.findByPK(any())).thenReturn(Optional.of(COMPANY_RESPONSE));
		when(companyService.existByPK(any())).thenReturn(true);
		when(companyService.create(any(), Mockito.anyString())).thenReturn(COMPANY_RESPONSE);
		when(companyService.update(any(), any(), Mockito.anyString())).thenReturn(Optional.of(COMPANY_RESPONSE));
	}

	// Get all andDo(print())
	@Test
	public void whenCallAPIGetAll_thenRetrieveEmptyList() throws Exception {
		when(companyService.findAll()).thenReturn(Collections.emptyList());

		mockMvc.perform(get(CompanyControllerConstant.BASE_URL)).andExpect(status().isNoContent());
	}

	@Test
	public void whenCallAPIGetAll_thenRetrieveAllElements() throws Exception {
		MvcResult result = mockMvc.perform(get(CompanyControllerConstant.BASE_URL)).andExpect(status().isOk())
				.andReturn();

		List<CompanyResponse> response = mapper.readValue(result.getResponse().getContentAsByteArray(),
				new TypeReference<List<CompanyResponse>>() {
				});

		assertEquals(COMPANY_RESPONSE_LIST, response);
	}

	// Find by id
	@Test
	public void whenCallAPIGetById_thenRetrieveNotFound() throws Exception {
		when(companyService.findByPK(any())).thenReturn(Optional.empty());
		
		mockMvc.perform(get(CompanyControllerConstant.BASE_URL + CompanyControllerConstant.GET_BY_ID_PATH, COMPANY_ID))
				.andExpect(status().isNotFound());
	}

	@Test
	public void whenCallAPIGetById_thenRetrieveElement() throws Exception {
		MvcResult result = mockMvc
				.perform(get(CompanyControllerConstant.BASE_URL + CompanyControllerConstant.GET_BY_ID_PATH, COMPANY_ID))
				.andExpect(status().isOk()).andReturn();

		CompanyResponse response = mapper.readValue(result.getResponse().getContentAsByteArray(),
				CompanyResponse.class);
		assertEquals(COMPANY_RESPONSE, response);
	}

	// Update
	@Test
	public void whenCallAPIUpdate_thenRetrieveNotFound() throws Exception {
		String content = RestUtil.covertToJsonResponse(new CompanyRequest(COMPANY_RESPONSE.getCompanyName()));

		when(companyService.update(any(), any(), Mockito.anyString())).thenReturn(Optional.empty());
		mockMvc.perform(put(CompanyControllerConstant.BASE_URL + CompanyControllerConstant.UPDATE_PATH, COMPANY_ID)
				.contentType(MediaType.APPLICATION_JSON).content(content)).andExpect(status().isNotFound());
	}

	@Test
	public void whenCallAPIUpdate_thenRetrieveUpdatedElement() throws Exception {

		String content = RestUtil.covertToJsonResponse(new CompanyRequest(COMPANY_RESPONSE.getCompanyName()));

		MvcResult result = mockMvc
				.perform(put(CompanyControllerConstant.BASE_URL + CompanyControllerConstant.UPDATE_PATH, COMPANY_ID)
						.contentType(MediaType.APPLICATION_JSON).content(content))
				.andExpect(status().isOk()).andReturn();

		CompanyResponse response = mapper.readValue(result.getResponse().getContentAsByteArray(),
				CompanyResponse.class);
		assertEquals(COMPANY_RESPONSE, response);
	}

	// Insert
	@Test
	public void whenCallAPICreate_thenRetrieveCreatedElement() throws Exception {

		String content = RestUtil.covertToJsonResponse(new CompanyRequest(COMPANY_RESPONSE.getCompanyName()));

		MvcResult result = mockMvc.perform(
				post(CompanyControllerConstant.BASE_URL).contentType(MediaType.APPLICATION_JSON).content(content))
				.andExpect(status().isCreated()).andReturn();

		CompanyResponse response = mapper.readValue(result.getResponse().getContentAsByteArray(),
				CompanyResponse.class);
		assertEquals(COMPANY_RESPONSE, response);

	}

}
