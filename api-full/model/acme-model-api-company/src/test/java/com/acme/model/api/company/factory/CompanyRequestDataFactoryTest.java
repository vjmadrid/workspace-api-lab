package com.acme.model.api.company.factory;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Test;

import com.acme.architecture.testing.util.JUnitTestUtil;
import com.acme.model.api.company.constant.DummyCompanyConstant;
import com.acme.model.api.company.entity.CompanyRequest;

public class CompanyRequestDataFactoryTest {
	
	@Test
	public void shouldCreateDefaultConstructor_ThenTrowIllegalStateException() {
		assertThrows(IllegalStateException.class, () -> {
			new CompanyRequestDataFactory();
		});
	}
	
	@Test
	public void whenCallACheckUtilClassWellDefined()
			throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		JUnitTestUtil.checkUtilClassWellDefined(CompanyRequestDataFactory.class);
	}

	@Test
	public void whenCallACreate_ThenCreateCompanyResponse() {
		CompanyRequest result = CompanyRequestDataFactory.create(DummyCompanyConstant.COMPANY_NAME);
		
		assertNotNull(result);
		assertEquals(DummyCompanyConstant.COMPANY_NAME,result.getCompanyName());
	}
	
}