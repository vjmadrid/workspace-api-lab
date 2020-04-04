package com.acme.model.api.common.response.audit.factory.dummy;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.acme.architecture.testing.util.JUnitTestUtil;
import com.acme.model.api.common.response.audit.constant.dummy.DummyAuditModelConstant;
import com.acme.model.api.common.response.audit.entity.AuditResponse;
import com.acme.model.api.common.response.audit.factory.dummy.DummyAuditResponseDataFactory;

public class DummyAuditResponseDataFactoryTest {

	@BeforeEach
	public void init() {
	}

	@Test
	public void shouldCreateDefaultConstructor_ThenTrowIllegalStateException() {

		assertThrows(IllegalStateException.class, () -> {
			new DummyAuditResponseDataFactory();
		});
	}
	
	@Test
	public void whenCallACheckUtilClassWellDefined()
			throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		JUnitTestUtil.checkUtilClassWellDefined(DummyAuditResponseDataFactory.class);
	}
	
	@Test
	public void whenCallACreateSampleDefault_ThenCreateAuditResponse() {
		assertNotNull(DummyAuditResponseDataFactory.createSampleDefault());
	}

	@Test
	public void whenCallACreateSampleMap_ThenResult() {
		Map<String, AuditResponse> result = DummyAuditResponseDataFactory.createSampleMap();
		
		assertNotNull(result);
		assertEquals(DummyAuditModelConstant.TEST_NUM_USERS,Integer.valueOf(result.size()));
	}
	
	@Test
	public void whenCallACreateSampleList_ThenResult() {
		List<AuditResponse> result = DummyAuditResponseDataFactory.createSampleList();
		
		assertNotNull(result);
		assertEquals(DummyAuditModelConstant.TEST_NUM_USERS,Integer.valueOf(result.size()));
	}

}