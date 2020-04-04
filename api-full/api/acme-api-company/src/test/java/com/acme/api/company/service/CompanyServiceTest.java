package com.acme.api.company.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import com.acme.api.company.entity.Company;
import com.acme.api.company.factory.dummy.DummyCompanyDataFactory;
import com.acme.api.company.mapper.CompanyMapper;
import com.acme.api.company.mapper.CompanyMapperImpl;
import com.acme.api.company.repository.ComapanyRepository;
import com.acme.api.company.service.impl.CompanyServiceImpl;
import com.acme.model.api.common.response.audit.constant.dummy.DummyAuditModelConstant;
import com.acme.model.api.company.constant.dummy.DummyCompanyModelConstant;
import com.acme.model.api.company.entity.CompanyResponse;
import com.acme.model.api.company.factory.dummy.DummyCompanyRequestDataFactory;
import com.acme.model.api.company.factory.dummy.DummyCompanyResponseDataFactory;

public class CompanyServiceTest {

	private CompanyServiceImpl companyService;

	private ComapanyRepository companyRepository;

	private CompanyMapper companyMapper;

	private ArgumentCaptor<Company> companyCaptor = ArgumentCaptor.forClass(Company.class);

	@BeforeEach
	public void init() {

		companyRepository = mock(ComapanyRepository.class);
		companyMapper = mock(CompanyMapperImpl.class);

		companyService = new CompanyServiceImpl();
		companyService.setCompanyRepository(companyRepository);
		companyService.setCompanyMapper(companyMapper);

		// Repository mocks
		when(companyRepository.findAll()).thenReturn(DummyCompanyDataFactory.createSampleDefaultList());
		when(companyRepository.findById(any())).thenReturn(Optional.of(DummyCompanyDataFactory.createSampleDefault()));
		when(companyRepository.findAllById(any())).thenReturn(DummyCompanyDataFactory.createSampleDefaultList());
		when(companyRepository.save(any())).thenReturn(DummyCompanyDataFactory.createSampleDefault());
		when(companyRepository.existsById(any())).thenReturn(true);

		// Mapper mocks
		when(companyMapper.toCompany(any())).thenReturn(DummyCompanyDataFactory.createSampleDefault());
		when(companyMapper.toCompanyResponse(any())).thenReturn(DummyCompanyResponseDataFactory.createSampleDefault());
		when(companyMapper.toCompanyResponseList(anyList())).thenReturn(DummyCompanyResponseDataFactory.createSampleDefaultList());
		when(companyMapper.toCompanyResponse(any())).thenReturn(DummyCompanyResponseDataFactory.createSampleDefault());

	}

	@Test
	public void whenCallFindAll_thenInvokeTheDaoMethodFindAll() {
		List<CompanyResponse> companyResponseList = companyService.findAll();
		
		verify(companyRepository).findAll();
		assertTrue(companyResponseList.size() == 1);
	}

	@Test
	public void whenCallFindPK_thenInvokeDaoMethodFindById() {
		Optional<CompanyResponse> companyResponse = companyService.findByPK(any());
		
		assertTrue(companyResponse.isPresent());
		verify(companyRepository).findById(any());
	}

	@Test
	public void whenCallFindPK_thenInvokeDaoMethodFindByIdNotFound() {
		when(companyRepository.findById(any())).thenReturn(Optional.empty());

		Optional<CompanyResponse> companyResponse = companyService.findByPK(any());
		assertFalse(companyResponse.isPresent());
		verify(companyRepository).findById(any());
	}
	
	@Test
	public void whenCallFindPKList_thenInvokeDaoMethodFindByAllId() {

		List<CompanyResponse> companyResponseList = companyService.findByPKList(any());
		verify(companyRepository).findAllById(any());
		assertTrue(companyResponseList.size() == 1);
	}

	@Test
	public void whenCallFindPKList_thenInvokeDaoMethodFindAllByIdNotFound() {

		when(companyRepository.findAllById(any())).thenReturn(Collections.emptyList());

		List<CompanyResponse> companyResponseList = companyService.findByPKList(any());
		verify(companyRepository).findAllById(any());
		assertTrue(companyResponseList.size() == 1);
	}

	@Test
	public void whenCallCreate_thenInvokeDaoMethodSave() {

		companyService.create(DummyCompanyRequestDataFactory.createSampleDefault(), DummyAuditModelConstant.CREATED_BY);
		verify(companyRepository).save(companyCaptor.capture());
		Company company = companyCaptor.getValue();
		assertEquals(DummyAuditModelConstant.CREATED_BY, company.getCreatedBy());
	}

	@Test
	public void whenCallUpdate_thenInvokeDaoMethodSave() {

		companyService.update(DummyCompanyModelConstant.COMPANY_ID, DummyCompanyRequestDataFactory.createSampleDefault(),
				DummyAuditModelConstant.MODIFIED_BY);
		verify(companyRepository).save(companyCaptor.capture());
		Company company = companyCaptor.getValue();
		assertEquals(DummyCompanyModelConstant.COMPANY_ID, company.getId());
		assertEquals(DummyAuditModelConstant.MODIFIED_BY, company.getModifiedBy());
		assertNotNull(company.getModifiedAt());
	}

	@Test
	public void whenCallExistByPK_thenInvokeDaoMethodExistId() {

		assertTrue(companyRepository.existsById(any()));
	}

}
