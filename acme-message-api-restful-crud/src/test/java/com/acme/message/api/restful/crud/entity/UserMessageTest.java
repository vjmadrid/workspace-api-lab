package com.acme.message.api.restful.crud.entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.acme.message.api.restful.crud.factory.dummy.DummyUserMessageDataFactory;

public class UserMessageTest {
	
	private UserMessage userMessage;

	private UserMessage anotherUserMessage;

	private UserMessage cloneUserMessage;
	
	@Before
	public void init() {
		userMessage = DummyUserMessageDataFactory.createSampleDefault();
		cloneUserMessage =  DummyUserMessageDataFactory.createSampleDefault();
		anotherUserMessage = DummyUserMessageDataFactory.createSampleDefault();
		anotherUserMessage.setId(2L);
	}
	
	@Test
	public void equalsMethodCheckTheType() {
		assertFalse(userMessage.equals("a string"));
	}

	@Test
	public void equalsMehtodCheckSameObject() throws Exception {
		assertTrue(userMessage.equals(userMessage));
	}
	
	@Test
	public void equalsMehtodCheckIdField() throws Exception {
		assertFalse(userMessage.equals(anotherUserMessage));
	}

	@Test
	public void equalsMehtodCheckIdFieldEquals() throws Exception {
		assertTrue(userMessage.equals(cloneUserMessage));
	}

	@Test
	public void hashproductMethodBasedInTheIDField() throws Exception {
		assertNotSame(userMessage.hashCode(), anotherUserMessage.hashCode());
	}

		
	@Test
	public void shouldHaveADescriptiveToStringMethod() {
		System.out.println("*** "+userMessage.toString());
		assertTrue(userMessage.toString().contains("{\"id\""));
	}

	@Test
	public void shouldHasMethodAccessors() {
		assertNotNull(userMessage.getId());
		assertNotNull(userMessage.getDescription());
		assertNotNull(userMessage.isVip());
		assertNotNull(userMessage.getCreationDate());
		assertNull(userMessage.getDeletedDate());
	}

}
