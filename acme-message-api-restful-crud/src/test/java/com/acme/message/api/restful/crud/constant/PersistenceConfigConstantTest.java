package com.acme.message.api.restful.crud.constant;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import com.acme.message.api.restful.crud.testing.JUnitTestBuilderUtil;

public class PersistenceConfigConstantTest {

	@Test
	public void whenCheckWellFormattedClass() throws NoSuchMethodException, InvocationTargetException,
			InstantiationException, IllegalAccessException {
		JUnitTestBuilderUtil.assertUtilityClassWellDefined(PersistenceConfigConstant.class);
	}

}
