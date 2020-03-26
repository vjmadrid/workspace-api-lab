package com.acme.model.api.common.response.audit.dummy.constant;

import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Test;

import com.acme.architecture.testing.util.JUnitTestUtil;
import com.acme.model.api.common.response.audit.dummy.constant.DummyAuditResponseConstant;

public class DummyAuditResponseConstantTest {

	@Test
	public void whenCallAcheckConstantClassWellDefined()
			throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		JUnitTestUtil.checkConstantClassWellDefined(DummyAuditResponseConstant.class);
	}
}
