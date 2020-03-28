package com.acme.model.api.common.response.audit.constant;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Test;

import com.acme.architecture.testing.util.JUnitTestUtil;

public class DummyAuditResponseConstantTest {

	@Test
	public void whenCallAcheckConstantClassWellDefined()
			throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		JUnitTestUtil.checkConstantClassWellDefined(DummyAuditResponseConstant.class);
	}
	
	@Test
	public void shouldHasMethodAccessors() {
		assertNotNull(DummyAuditResponseConstant.getCreatedAt());
		assertNotNull(DummyAuditResponseConstant.getModifiedAt());
	}
}
