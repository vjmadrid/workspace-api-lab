package com.acme.model.api.company.entity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.acme.model.api.company.constant.DummyCompanyConstant;
import com.acme.model.api.company.factory.DummyCompanyResponseDataFactory;

public class CompanyResponseTest {
	
	private final String VALIDATION_FIELD_CONTAINS_TO_STRING = "companyName";
	
	private CompanyResponse entity;

	private CompanyResponse anotherEntity;

	private CompanyResponse cloneEntity;
	
	@BeforeEach
	public void init() {
		entity = DummyCompanyResponseDataFactory.createSampleDefault();
		cloneEntity =  DummyCompanyResponseDataFactory.createSampleDefault();
		anotherEntity = DummyCompanyResponseDataFactory.createSampleDefault();
		anotherEntity.setId(2L);
	}
	
	@Test
	public void whenCallAConstructorWithParameters_ThenReturnObject() {
		CompanyResponse result =  new CompanyResponse(DummyCompanyConstant.COMPANY_ID, DummyCompanyConstant.COMPANY_NAME);
		
		assertNotNull(result);
		assertNotNull(result.getId());
		assertNotNull(result.getCompanyName());
	}
	
	@Test
	public void whenCallAEqualsWithString_ThenReturnFalse() {
		assertFalse(entity.equals("a string"));
	}

	@Test
	public void whenCallAEqualsWithSameObject_ThenReturnFalse() throws Exception {
		assertTrue(entity.equals(entity));
	}
	
	@Test
	public void whenCallAEqualsWithAnotherObject_ThenReturnFalse() throws Exception {
		assertFalse(entity.equals(anotherEntity));
	}

	@Test
	public void whenCallAEqualsWithValueCloneObject_ThenReturnTrue() throws Exception {	
		assertTrue(entity.equals(cloneEntity));
	}

	@Test
	public void whenCallAHasCodeWithAnotherObject_ThenReturnNotSame() throws Exception {
		assertNotSame(entity.hashCode(), anotherEntity.hashCode());
	}
	
	@Test
	public void whenCallAToString_ThenReturnStringWithField() {
		System.out.println("*** "+entity.toString());
		assertTrue(entity.toString().contains(VALIDATION_FIELD_CONTAINS_TO_STRING));
	}

	@Test
	public void whenCallAMethodsAccessor_ThenReturnValue() {
		assertNotNull(entity.getId());
		assertNotNull(entity.getCompanyName());
	}

}
