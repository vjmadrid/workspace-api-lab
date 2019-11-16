package com.acme.message.api.restful.crud.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.acme.message.api.restful.crud.entity.UserMessage;
import com.acme.message.api.restful.crud.factory.dummy.DummyUserMessageDataFactory;

public class UserMessageValidatorTest {

	private UserMessage userMessageTest;

	@Before
	public void init() {
		userMessageTest = DummyUserMessageDataFactory.createSampleDefault();
	}

	@Test
	public void shouldIsNull() {
		assertTrue(UserMessageValidator.INSTANCE.isNull(null));
	}

	@Test
	public void shouldIsNullWithUserMessageNotNull() {
		assertFalse(UserMessageValidator.INSTANCE.isNull(userMessageTest));
	}

	@Test
	public void shouldIsNotNull() {
		assertTrue(UserMessageValidator.INSTANCE.isNotNull(userMessageTest));
	}

	@Test
	public void shouldIsNotNullWithUserMessageNull() {
		assertFalse(UserMessageValidator.INSTANCE.isNotNull(null));
	}

	@Test
	public void shouldIsValidWithUserMessageNull() {
		assertFalse(UserMessageValidator.INSTANCE.isValid(null));
	}

	@Test
	public void shouldIsValidWithIdUserMessageNull() {
		userMessageTest.setId(null);
		assertFalse(UserMessageValidator.INSTANCE.isValid(userMessageTest));
	}

	@Test
	public void shouldIsValid() {
		assertTrue(UserMessageValidator.INSTANCE.isValid(userMessageTest));
	}
	
	@Test
	public void shouldIsValidVipWithUserMessageNull() {
		assertFalse(UserMessageValidator.INSTANCE.isValidVip(null));
	}
	
	@Test
	public void shouldIsValidVipWithIdUserMessageNull() {
		userMessageTest.setId(null);
		assertFalse(UserMessageValidator.INSTANCE.isValidVip(userMessageTest));
	}

	@Test
	public void shouldIsValidVipNoValidValue() {
		assertFalse(UserMessageValidator.INSTANCE.isValidVip(userMessageTest));
	}
	
	@Test
	public void shouldIsValidVip() {
		userMessageTest.setVip(true);
		assertTrue(UserMessageValidator.INSTANCE.isValidVip(userMessageTest));
	}
	
	@Test
	public void shouldIsDeletedLogicalVipWithIdUserMessageNull() {
		userMessageTest.setId(null);
		assertFalse(UserMessageValidator.INSTANCE.isDeletedLogical(userMessageTest));
	}
	
	@Test
	public void shouldIsDeletedLogicalVipNoValidValue() {
		assertFalse(UserMessageValidator.INSTANCE.isDeletedLogical(userMessageTest));
	}
	
	@Test
	public void shouldUsDeletedLogical() {
		userMessageTest.setDeletedDate(new Date());
		assertTrue(UserMessageValidator.INSTANCE.isDeletedLogical(userMessageTest));
	}
	

}