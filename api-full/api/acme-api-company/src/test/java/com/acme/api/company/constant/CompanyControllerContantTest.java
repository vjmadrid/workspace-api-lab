package com.acme.api.company.constant;

import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Test;

import com.acme.api.company.constant.CompanyControllerConstant;
import com.acme.architecture.testing.util.JUnitTestUtil;

public class CompanyControllerContantTest {

	@Test
	public void whenCallAcheckConstantClassWellDefined()
			throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		JUnitTestUtil.checkConstantClassWellDefined(CompanyControllerConstant.class);
	}
}
