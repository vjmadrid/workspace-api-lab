package com.acme.model.api.company.factory.dummy;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.acme.architecture.testing.util.JUnitTestUtil;
import com.acme.model.api.company.constant.dummy.DummyCompanyModelConstant;
import com.acme.model.api.company.entity.CompanyRequest;


public class DummyCompanyRequestDataFactoryTest {

	@BeforeEach
	public void init() {
	}

	@Test
	public void shouldCreateDefaultConstructor_ThenTrowIllegalStateException() {
		assertThrows(IllegalStateException.class, () -> {
			new DummyCompanyRequestDataFactory();
		});
	}
	
	@Test
	public void whenCallACheckUtilClassWellDefined()
			throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		JUnitTestUtil.checkUtilClassWellDefined(DummyCompanyRequestDataFactory.class);
	}

	@Test
	public void whenCallACreateSampleDefault_ThenCreateCompanyRequest() {
		assertNotNull(DummyCompanyRequestDataFactory.createSampleDefault());
	}
	
	@Test
	public void whenCallACreateSampleMap_ThenResult() {
		Map<Long, CompanyRequest> result = DummyCompanyRequestDataFactory.createSampleMap();
		
		assertNotNull(result);
		assertEquals(DummyCompanyModelConstant.TEST_NUM_COMPANIES,Integer.valueOf(result.size()));
	}
	
	@Test
	public void whenCallACreateSampleList_ThenResult() {
		List<CompanyRequest> result = DummyCompanyRequestDataFactory.createSampleList();
		
		assertNotNull(result);
		assertEquals(DummyCompanyModelConstant.TEST_NUM_COMPANIES,Integer.valueOf(result.size()));
	}
	
	@Test
	public void whenCallACreateDefaultList_ThenResult() {
		List<CompanyRequest> result = DummyCompanyRequestDataFactory.createSampleDefaultList();
		
		assertNotNull(result);
		assertEquals(1,Integer.valueOf(result.size()));
	}

	@Test
	public void whenCallACreateDefaultArray_ThenResult() {
		CompanyRequest[] result = DummyCompanyRequestDataFactory.createSampleDefaultArray();
		
		assertNotNull(result);
		assertEquals(1,Integer.valueOf(result.length));
	}
	

}