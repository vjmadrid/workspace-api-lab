package com.acme.message.api.restful.crud.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.acme.message.api.restful.crud.constant.UserMessageConstant;
import com.acme.message.api.restful.crud.entity.UserMessage;
import com.acme.message.api.restful.crud.factory.dummy.DummyUserMessageDataFactory;
import com.acme.message.api.restful.crud.service.UserMessageService;

public class UserMessageAPITest {
	
	private UserMessageAPI userMessageAPI;

	private UserMessageService userMessageService;
	
	private List<UserMessage> userMessageListTest;
	
	private UserMessage userMessageTest;
	
	@Before
	public final void setUp() throws Exception {
		userMessageTest = DummyUserMessageDataFactory.createSampleDefault();
		userMessageListTest = DummyUserMessageDataFactory.createSampleList();

		userMessageAPI = spy(new UserMessageAPI());
		userMessageService = mock(UserMessageService.class);
		
		when(userMessageService.findByPK(anyLong())).thenReturn(Optional.of(userMessageTest));
		when(userMessageService.findAll()).thenReturn(userMessageListTest);
		
		userMessageAPI.setUserMessageService(userMessageService);

	}

	@Test
	public final void whenCallFindAllAndServiceNullInvalid_thenReturnHttpOkAndEmptyBody() {
		when(userMessageService.findAll()).thenReturn(null);
		
		final ResponseEntity<List<UserMessage>> responseEntity = userMessageAPI.findAll();
		
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
		assertNull(responseEntity.getBody());
	}
	
	@Test
	public final void whenCallFindAllAndServiceValid_thenReturnHttpOkAndBody() {
		final ResponseEntity<List<UserMessage>> responseEntity = userMessageAPI.findAll();
		
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	
	@Test
	public final void whenCallFindByIdAndServiceNullInvalid_thenReturnHttpOkAndEmptyBody() {
		userMessageTest = null;
		when(userMessageService.findByPK(anyLong())).thenReturn(Optional.ofNullable(userMessageTest));
		
		final ResponseEntity<UserMessage> responseEntity = (ResponseEntity<UserMessage>) userMessageAPI.findById(UserMessageConstant.TEST_USER_MESSAGE_1_ID);
		
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
		assertNull(responseEntity.getBody());
	}
	
	@Test
	public final void whenCallFindByIdAndServiceValid_thenReturnHttpOkAndBody() {
		final ResponseEntity<UserMessage> responseEntity = (ResponseEntity<UserMessage>) userMessageAPI.findById(UserMessageConstant.TEST_USER_MESSAGE_1_ID);
		
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	
	@Test
	public final void whenCallCreateAndServiceValid_thenReturnHttpCreatedAndBody() {
		final ResponseEntity<UserMessage> responseEntity = (ResponseEntity<UserMessage>) userMessageAPI.create(userMessageTest);
		
		assertEquals(HttpStatus.CREATED,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	
	@Test
	public final void whenCallUpdateAndServiceValid_thenReturnHttpAcceptedAndBody() {
		final ResponseEntity<UserMessage> responseEntity = (ResponseEntity<UserMessage>) userMessageAPI.update(UserMessageConstant.TEST_USER_MESSAGE_1_ID,userMessageTest);
		
		assertEquals(HttpStatus.ACCEPTED,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	
	@Test
	public final void whenCallDeleteAndServiceValid_thenReturnHttpAcceptedAndEmptyBody() {
		final ResponseEntity<UserMessage> responseEntity = (ResponseEntity<UserMessage>) userMessageAPI.delete(UserMessageConstant.TEST_USER_MESSAGE_1_ID);
		
		assertEquals(HttpStatus.ACCEPTED,responseEntity.getStatusCode());
		assertNull(responseEntity.getBody());
	}
		
	
	
}
