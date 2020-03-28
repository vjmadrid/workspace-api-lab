package com.acme.model.api.company.factory;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.acme.architecture.testing.util.JUnitTestUtil;
import com.acme.model.api.company.constant.DummyCompanyConstant;
import com.acme.model.api.company.entity.CompanyResponse;

public class DummyCompanyResponseDataFactoryTest {

	@BeforeEach
	public void init() {
	}

	@Test
	public void shouldCreateDefaultConstructor_ThenTrowIllegalStateException() {

		assertThrows(IllegalStateException.class, () -> {
			new DummyCompanyResponseDataFactory();
		});
	}
	
	@Test
	public void whenCallACheckUtilClassWellDefined()
			throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		JUnitTestUtil.checkUtilClassWellDefined(DummyCompanyResponseDataFactory.class);
	}

	@Test
	public void whenCallACreateSampleDefault_ThenCreateAuditResponse() {
		assertNotNull(DummyCompanyResponseDataFactory.createSampleDefault());
	}
	
	@Test
	public void whenCallACreateSampleMap_ThenResult() {
		Map<Long, CompanyResponse> result = DummyCompanyResponseDataFactory.createSampleMap();
		
		assertNotNull(result);
		assertEquals(DummyCompanyConstant.TEST_NUM_COMPANIES,Integer.valueOf(result.size()));
	}
	
	@Test
	public void whenCallACreateSampleList_ThenResult() {
		List<CompanyResponse> result = DummyCompanyResponseDataFactory.createSampleList();
		
		assertNotNull(result);
		assertEquals(DummyCompanyConstant.TEST_NUM_COMPANIES,Integer.valueOf(result.size()));
	}
	
	@Test
	public void whenCallACreateDefaultList_ThenResult() {
		List<CompanyResponse> result = DummyCompanyResponseDataFactory.createSampleDefaultList();
		
		assertNotNull(result);
		assertEquals(1,Integer.valueOf(result.size()));
	}

	@Test
	public void whenCallACreateDefaultArray_ThenResult() {
		CompanyResponse[] result = DummyCompanyResponseDataFactory.createSampleDefaultArray();
		
		assertNotNull(result);
		assertEquals(1,Integer.valueOf(result.length));
	}
	

}