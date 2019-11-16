package com.acme.message.api.restful.crud.exception.enumerate;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import com.acme.message.api.restful.crud.testing.JUnitTestBuilderUtil;

public class UserMessageTypeExceptionEnumTest {

	@Test
	public void whenCheckWellFormattedClass() throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		JUnitTestBuilderUtil.superficialEnumCodeCoverage(UserMessageTypeExceptionEnum.class);
	}

}
