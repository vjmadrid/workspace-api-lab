package com.acme.message.api.restful.crud.config.constant;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import com.acme.message.api.restful.crud.config.constant.MessageApiCrudConfigConstant;
import com.acme.message.api.restful.crud.testing.JUnitTestBuilderUtil;

public class MessageApiCrudConfigConstantTest {

	@Test
	public void whenCheckWellFormattedClass() throws NoSuchMethodException, InvocationTargetException,
			InstantiationException, IllegalAccessException {
		JUnitTestBuilderUtil.assertUtilityClassWellDefined(MessageApiCrudConfigConstant.class);
	}

}
