package com.acme.model.api.common.response.audit.entity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.acme.model.api.common.response.audit.constant.dummy.DummyAuditModelConstant;
import com.acme.model.api.common.response.audit.factory.dummy.DummyAuditResponseDataFactory;

public class AuditResponseTest {
	
	private final String VALIDATION_FIELD_CONTAINS_TO_STRING = "createdBy";
	
	private AuditResponse entity;

	private AuditResponse anotherEntity;

	private AuditResponse cloneEntity;
	
	@BeforeEach
	public void init() {
		entity = DummyAuditResponseDataFactory.createSampleDefault();
		cloneEntity =  DummyAuditResponseDataFactory.createSampleDefault();
		anotherEntity = DummyAuditResponseDataFactory.createSampleDefault();
		anotherEntity.setCreatedBy("admin");
	}
	
	@Test
	public void whenCallAConstructorWithParameters_ThenReturnObject() {
		AuditResponse result =  new AuditResponse(DummyAuditModelConstant.CREATED_BY,new Date(),null, null);
		
		assertNotNull(result);
		assertNotNull(result.getCreatedBy());
		assertNotNull(result.getCreatedAt());
		assertNull(result.getModifiedBy());
		assertNull(result.getModifiedAt());
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
		//System.out.println("*** "+entity.toString());
		assertTrue(entity.toString().contains(VALIDATION_FIELD_CONTAINS_TO_STRING));
	}

	@Test
	public void whenCallAMethodsAccessor_ThenReturnValue() {	
		assertNotNull(entity.getCreatedBy());
		assertNotNull(entity.getCreatedAt());
		assertNull(entity.getModifiedBy());
		assertNull(entity.getModifiedAt());
	}

}
