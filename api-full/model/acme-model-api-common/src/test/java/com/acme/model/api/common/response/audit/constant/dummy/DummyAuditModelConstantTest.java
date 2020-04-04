package com.acme.model.api.common.response.audit.constant.dummy;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Test;

import com.acme.architecture.testing.util.JUnitTestUtil;
import com.acme.model.api.common.response.audit.constant.dummy.DummyAuditModelConstant;

public class DummyAuditModelConstantTest {

	@Test
	public void whenCallAcheckConstantClassWellDefined()
			throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		JUnitTestUtil.checkConstantClassWellDefined(DummyAuditModelConstant.class);
	}
	
	@Test
	public void shouldHasMethodAccessors() {
		assertNotNull(DummyAuditModelConstant.getCreatedAt());
		assertNotNull(DummyAuditModelConstant.getModifiedAt());
	}
}
