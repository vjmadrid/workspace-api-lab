package com.acme.model.api.common.factory.dummy;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.acme.architecture.testing.util.JUnitTestUtil;

public class DummyDateTimeDataFactoryTest {

	@BeforeEach
	public void init() {
	}

	@Test
	public void shouldCreateDefaultConstructor_ThenTrowIllegalStateException() {
		assertThrows(IllegalStateException.class, () -> {
			new DummyDateTimeDataFactory();
		});
	}
	
	@Test
	public void whenCallACheckUtilClassWellDefined()
			throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		JUnitTestUtil.checkUtilClassWellDefined(DummyDateTimeDataFactory.class);
	}

	@Test
	public void whenCallAGetDate_ThenResult() {
		assertNotNull(DummyDateTimeDataFactory.getDate());
	}
	
	@Test
	public void whenCallAGetFutureDate_ThenResult() {
		Date valueDate = DummyDateTimeDataFactory.getDate();
		Date futureDate = DummyDateTimeDataFactory.getFutureDate();
		
		assertNotNull(valueDate);
		assertNotNull(futureDate);
	}
	
	@Test
	public void whenCallAAsLocalDateTime_ThenResult() {
		LocalDateTime result = DummyDateTimeDataFactory.asLocalDateTime(new Date());
		
		assertNotNull(result);
	}
	
	

}