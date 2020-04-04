package com.acme.model.api.common.response.audit.factory;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.acme.architecture.testing.util.JUnitTestUtil;
import com.acme.model.api.common.response.audit.constant.dummy.DummyAuditModelConstant;
import com.acme.model.api.common.response.audit.entity.AuditResponse;

public class AuditResponseDataFactoryTest {

	@BeforeEach
	public void init() {
	}
	
	@Test
	public void shouldCreateDefaultConstructor_ThenTrowIllegalStateException() {

		assertThrows(IllegalStateException.class, () -> {
			new AuditResponseDataFactory();
		});
	}
	
	@Test
	public void whenCallACheckUtilClassWellDefined()
			throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		JUnitTestUtil.checkUtilClassWellDefined(AuditResponseDataFactory.class);
	}
	
	@Test
	public void whenCallACreate_ThenCreateAuditResponse() {
		AuditResponse result = AuditResponseDataFactory.create(DummyAuditModelConstant.CREATED_BY);
		
		assertNotNull(result);
		assertEquals(DummyAuditModelConstant.CREATED_BY,result.getCreatedBy());
		assertNotNull(result.getCreatedAt());
	}
	
	@Test
	public void whenCallACreateUpdated_ThenCreateAuditResponse() {
		AuditResponse result = AuditResponseDataFactory.createUpdated(DummyAuditModelConstant.CREATED_BY, DummyAuditModelConstant.MODIFIED_BY);
		
		assertNotNull(result);
		assertEquals(DummyAuditModelConstant.CREATED_BY,result.getCreatedBy());
		assertNotNull(result.getCreatedAt());
		assertEquals(DummyAuditModelConstant.CREATED_BY,result.getModifiedBy());
		assertNotNull(result.getModifiedAt());
	}
	
}