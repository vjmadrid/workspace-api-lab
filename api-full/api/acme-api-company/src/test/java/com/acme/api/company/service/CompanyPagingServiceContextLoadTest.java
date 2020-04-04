package com.acme.api.company.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.acme.api.company.mapper.CompanyMapperImpl;
import com.acme.api.company.mapper.struct.CompanyMapperStruct;
import com.acme.api.company.service.impl.CompanyPagingServiceImpl;
import com.acme.architecture.core.constant.DefaultSpringConfigConstant;
import com.acme.model.api.company.entity.CompanyResponse;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles(profiles = { DefaultSpringConfigConstant.SPRING_PROFILE_LOCAL })
public class CompanyPagingServiceContextLoadTest {

	private static final Integer PAGE_NUMBER = 0;
	private static final Integer PAGE_SIZE = 1;
	private static final String SORT_PROPERTY = "companyId";
	private static final String SORT_ORDER_DESC = "desc";
	private static final String SORT_ORDER_ASC = "asc";

	@Autowired
	private CompanyPagingServiceImpl companyPagingServiceImpl;

	@Autowired
	private CompanyMapperStruct mapperStruct;

	@Autowired
	private CompanyMapperImpl companyMapper;

	@BeforeEach
	public void init() {
		companyMapper.setMapperStruct(mapperStruct);
	}

	@Test
	public void whenCallFindAllOrderDesc_thenInvokeTheDaoMethodFindAll() {
		Page<CompanyResponse> pageResponse = companyPagingServiceImpl.findAll(PAGE_NUMBER, PAGE_SIZE, SORT_PROPERTY,
				SORT_ORDER_DESC);

		assertTrue(pageResponse.getContent().size() == 1);
		assertTrue(pageResponse.getContent().get(0).getId() > 1);
	}

	@Test
	public void whenCallFindAllOrderAsc_thenInvokeTheDaoMethodFindAll() {
		Page<CompanyResponse> pageResponse = companyPagingServiceImpl.findAll(PAGE_NUMBER, PAGE_SIZE, SORT_PROPERTY,
				SORT_ORDER_ASC);

		assertTrue(pageResponse.getContent().size() == 1);
		assertTrue(pageResponse.getContent().get(0).getId() == 1);
	}

}
