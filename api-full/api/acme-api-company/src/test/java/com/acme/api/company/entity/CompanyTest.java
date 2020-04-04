package com.acme.api.company.entity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.acme.api.company.factory.dummy.DummyCompanyDataFactory;

public class CompanyTest {
	
	private final String VALIDATION_FIELD_CONTAINS_TO_STRING = "companyName";
	
	private Company entity;

	private Company anotherEntity;

	private Company cloneEntity;
	
	@BeforeEach
	public void init() {
		entity = DummyCompanyDataFactory.createSampleDefault();
		cloneEntity =  DummyCompanyDataFactory.createSampleDefault();
		anotherEntity = DummyCompanyDataFactory.createSampleDefault();
		anotherEntity.setId(2L);
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
