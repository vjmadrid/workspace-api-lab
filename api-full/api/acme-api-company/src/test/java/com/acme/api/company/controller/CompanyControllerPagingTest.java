package com.acme.api.company.controller;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.acme.api.company.constant.CompanyControllerConstant;
import com.acme.api.company.service.CompanyPagingService;
import com.acme.api.company.service.CompanyService;
import com.acme.architecture.core.response.PageableResponse;
import com.acme.model.api.company.entity.CompanyResponse;
import com.acme.model.api.company.factory.dummy.DummyCompanyResponseDataFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CompanyPagingController.class)
public class CompanyControllerPagingTest {
	
	private List<CompanyResponse> COMPANY_RESPONSE_LIST = DummyCompanyResponseDataFactory.createSampleDefaultList();

	private static final String PAGING_FILTER = "?pageNumber=0&pageSize=1&sortProperty=companyId&sortOrder=desc";

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CompanyService companyService;

	@MockBean
	private CompanyPagingService companyPagingService;

	private ObjectMapper mapper = new ObjectMapper();

	@BeforeEach
	public void init() {
		Page<CompanyResponse> page = createCompanyResposePage(COMPANY_RESPONSE_LIST);
		
		when(companyPagingService.findAll(anyInt(), anyInt(), anyString(), anyString())).thenReturn(page);
	}

	@Test
	public void whenCallAPIGetAll_thenRetrieveEmptyList() throws Exception {
		Page<CompanyResponse> page = createCompanyResposePage(Collections.emptyList());
		
		System.out.println("mockMvc ::" +mockMvc);
		System.out.println("page ::" +page);
		System.out.println("companyPagingService ::" +companyPagingService);
		
		when(companyPagingService.findAll(anyInt(), anyInt(), anyString(), anyString())).thenReturn(page);
		
		mockMvc.perform(get(CompanyControllerConstant.BASE_URL + CompanyControllerConstant.GET_PAGING + PAGING_FILTER))
				.andExpect(status().isNoContent());
	}

	@Test
	public void whenCallAPIGetAll_thenRetrieveAllElements() throws Exception {
		MvcResult result = mockMvc
				.perform(get(CompanyControllerConstant.BASE_URL + CompanyControllerConstant.GET_PAGING + PAGING_FILTER))
				.andExpect(status().isOk()).andReturn();

		PageableResponse response = mapper.readValue(result.getResponse().getContentAsByteArray(),
				PageableResponse.class);

		assertTrue(response.getContent().size() == 1);
		assertTrue(response.getTotalPages() == 1);
		assertTrue(response.getPageNumber() == 0);
		assertTrue(response.getPageSize() == 1);
	}

	private Page<CompanyResponse> createCompanyResposePage(List<CompanyResponse> list) {
		return new PageImpl<CompanyResponse>(list, PageRequest.of(0, 1, Sort.unsorted()), list.size());
	}

}
