package com.acme.api.company.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.acme.api.company.mapper.CompanyMapperImpl;
import com.acme.api.company.mapper.struct.CompanyMapperStruct;
import com.acme.api.company.service.impl.CompanyServiceImpl;
import com.acme.architecture.common.util.ListUtil;
import com.acme.architecture.core.constant.DefaultSpringConfigConstant;
import com.acme.model.api.common.response.audit.constant.dummy.DummyAuditModelConstant;
import com.acme.model.api.company.constant.dummy.DummyCompanyModelConstant;
import com.acme.model.api.company.entity.CompanyResponse;
import com.acme.model.api.company.factory.dummy.DummyCompanyRequestDataFactory;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles(profiles = { DefaultSpringConfigConstant.SPRING_PROFILE_LOCAL })
public class CompanyServiceContextLoadTest {
	
	private static final Integer MAX_ELEMENTS = 3;
	private static final Long ID_EXIST = 1L;
	private static final Long ID_NOT_EXIST = 100L;
	private static final String ID_EXIST_LIST = "1,2,3";
	private static final String ID_NOT_EXIST_LIST = "100,101";

	@Autowired
	private CompanyServiceImpl companyService;

	@Autowired
	private CompanyMapperStruct mapperStruct;

	@Autowired
	private CompanyMapperImpl companyMapper;

	@BeforeEach
	public void init() {
		companyMapper.setMapperStruct(mapperStruct);
	}

	@Test
	public void whenCallFindAll_thenInvokeTheDaoMethodFindAll() {
		List<CompanyResponse> companyResponseList = companyService.findAll();

		assertTrue(companyResponseList.size() == MAX_ELEMENTS);
	}

	@Test
	public void whenCallFindPK_thenInvokeDaoMethodFindByIdExist() {
		Optional<CompanyResponse> companyResponse = companyService.findByPK(ID_EXIST);
		
		assertTrue(companyResponse.isPresent());
	}

	@Test
	public void whenCallFindPK_thenInvokeDaoMethodFindByIdNotExist() {
		Optional<CompanyResponse> companyResponse = companyService.findByPK(ID_NOT_EXIST);
		assertFalse(companyResponse.isPresent());
	}

	@Test
	public void whenCallFindPKList_thenInvokeDaoMethodFindByListIdExist() {
		List<String> listStringTokenizer = ListUtil.getTokensByStringTokenizer(ID_EXIST_LIST);
		List<Long> idList = listStringTokenizer.stream().map(Long::parseLong).collect(Collectors.toList());

		List<CompanyResponse> companyResponseList = companyService.findByPKList(idList);
		assertTrue(companyResponseList.size() == MAX_ELEMENTS);
	}

	@Test
	public void whenCallFindPKList_thenInvokeDaoMethodFindByListIdNotExist() {
		
		List<String> listStringTokenizer = ListUtil.getTokensByStringTokenizer(ID_NOT_EXIST_LIST);
		List<Long> idList = listStringTokenizer.stream().map(Long::parseLong).collect(Collectors.toList());

		List<CompanyResponse> companyResponseList = companyService.findByPKList(idList);
		assertTrue(companyResponseList.isEmpty());
	}
	
	@Test
	public void whenCallCreate_thenInvokeDaoMethodSave() {
		
		CompanyResponse companyResponse = companyService.create(DummyCompanyRequestDataFactory.createSampleDefault(),
				DummyAuditModelConstant.CREATED_BY);

		assertTrue(MAX_ELEMENTS + 1 == companyResponse.getId());
	}

	@Test
	public void whenCallUpdate_thenInvokeDaoMethodSave() {

		Optional<CompanyResponse> companyResponse = companyService.update(DummyCompanyModelConstant.COMPANY_ID,
				DummyCompanyRequestDataFactory.createSampleDefault(), DummyAuditModelConstant.MODIFIED_BY);

		assertTrue(companyResponse.isPresent());
		assertEquals(DummyCompanyModelConstant.COMPANY_ID, companyResponse.get().getId());
		assertEquals(DummyAuditModelConstant.MODIFIED_BY, companyResponse.get().getModifiedBy());
		assertNotNull(companyResponse.get().getModifiedAt());
	}

	@Test
	public void whenCallUpdateNotFound_thenInvokeDaoMethodSave() {
		Optional<CompanyResponse> companyResponse = companyService.update(ID_NOT_EXIST,
				DummyCompanyRequestDataFactory.createSampleDefault(), DummyAuditModelConstant.MODIFIED_BY);

		assertFalse(companyResponse.isPresent());
	}

	@Test
	public void whenCallExistByPK_thenInvokeDaoMethodExistId() {
		assertTrue(companyService.existByPK(ID_EXIST));
	}
}
