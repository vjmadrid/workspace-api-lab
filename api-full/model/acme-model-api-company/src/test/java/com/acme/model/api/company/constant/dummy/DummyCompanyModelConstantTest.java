package com.acme.model.api.company.constant.dummy;

import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Test;

import com.acme.architecture.testing.util.JUnitTestUtil;

public class DummyCompanyModelConstantTest {

	@Test
	public void whenCallAcheckConstantClassWellDefined()
			throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		JUnitTestUtil.checkConstantClassWellDefined(DummyCompanyModelConstant.class);
	}
}
