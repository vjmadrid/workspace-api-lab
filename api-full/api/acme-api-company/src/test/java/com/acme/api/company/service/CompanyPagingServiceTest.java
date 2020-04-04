package com.acme.api.company.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.acme.api.company.entity.Company;
import com.acme.api.company.factory.dummy.DummyCompanyDataFactory;
import com.acme.api.company.mapper.CompanyMapper;
import com.acme.api.company.mapper.CompanyMapperImpl;
import com.acme.api.company.repository.CompanyPagingAndSortRepository;
import com.acme.api.company.service.impl.CompanyPagingServiceImpl;
import com.acme.model.api.company.entity.CompanyResponse;
import com.acme.model.api.company.factory.dummy.DummyCompanyResponseDataFactory;

public class CompanyPagingServiceTest {

	private Page<Company> PAGE = DummyCompanyDataFactory.createSampleDefaultPage();

	private CompanyPagingServiceImpl companyPagingService;

	private CompanyPagingAndSortRepository companyPagingAndSortRepository;

	private CompanyMapper companyMapper;

	@BeforeEach
	public void init() {
		companyPagingAndSortRepository = mock(CompanyPagingAndSortRepository.class);
		companyMapper = mock(CompanyMapperImpl.class);

		companyPagingService = new CompanyPagingServiceImpl();
		companyPagingService.setCompanyPagingAndSortRepository(companyPagingAndSortRepository);
		companyPagingService.setCompanyMapper(companyMapper);

		// Repository mocks
		when(companyPagingAndSortRepository.findAll(any(Pageable.class))).thenReturn(PAGE);

		// Mapper mocks
		when(companyMapper.toCompanyResponseList(anyList()))
				.thenReturn(DummyCompanyResponseDataFactory.createSampleDefaultList());
	}

	@Test
	public void whenCallFindAllByParams_thenInvokeTheDaoMethodFindAll() {

		Page<CompanyResponse> page = companyPagingService.findAll(0, 1, "companyId", "desc");
		assertTrue(page.getContent().size() == 1);
		assertTrue(page.getTotalElements() == 1);
	}

	@Test
	public void whenCallFindAll_thenInvokeTheDaoMethodFindAll() {

		Page<CompanyResponse> page = companyPagingService.findAll(mock(Pageable.class));
		assertTrue(page.getContent().size() == 1);
		assertTrue(page.getTotalElements() == 1);
	}

}
