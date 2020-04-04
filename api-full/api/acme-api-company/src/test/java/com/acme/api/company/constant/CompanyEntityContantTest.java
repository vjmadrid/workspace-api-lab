package com.acme.api.company.constant;

import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Test;

import com.acme.api.company.constant.CompanyEntityConstant;
import com.acme.architecture.testing.util.JUnitTestUtil;

public class CompanyEntityContantTest {

	@Test
	public void whenCallAcheckConstantClassWellDefined()
			throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		JUnitTestUtil.checkConstantClassWellDefined(CompanyEntityConstant.class);
	}
}
