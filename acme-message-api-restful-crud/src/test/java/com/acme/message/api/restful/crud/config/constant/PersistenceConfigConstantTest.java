package com.acme.message.api.restful.crud.config.constant;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import com.acme.message.api.restful.crud.config.constant.PersistenceConfigConstant;
import com.acme.message.api.restful.crud.testing.JUnitTestBuilderUtil;

public class PersistenceConfigConstantTest {

	@Test
	public void whenCheckWellFormattedClass() throws NoSuchMethodException, InvocationTargetException,
			InstantiationException, IllegalAccessException {
		JUnitTestBuilderUtil.assertUtilityClassWellDefined(PersistenceConfigConstant.class);
	}

}
