package com.acme.message.api.restful.crud.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.acme.message.api.restful.crud.constant.UserMessageConstant;
import com.acme.message.api.restful.crud.entity.UserMessage;
import com.acme.message.api.restful.crud.factory.dummy.DummyUserMessageDataFactory;
import com.acme.message.api.restful.crud.service.UserMessageService;

public class UserMessageRestApiControllerTest {
	
	private final String MESSAGE_SOURCE_VALUE = "Error Message TEST";
	
	private UserMessageController userMessageController;

	private UserMessageService userMessageService;
	
	private List<UserMessage> userMessageListTest;
	
	private UserMessage userMessageTest;
	
	private HttpServletRequest request;
	
	private MessageSource messageSource;
	
	private UriComponentsBuilder uriComponentsBuilder;
	
	@Before
	public final void setUp() throws Exception {
		userMessageTest = DummyUserMessageDataFactory.createSampleDefault();
		userMessageListTest = DummyUserMessageDataFactory.createSampleList();

		userMessageController = spy(new UserMessageController());
		userMessageService = mock(UserMessageService.class);
		
		request = mock(HttpServletRequest.class);
		messageSource = mock(MessageSource.class);
		uriComponentsBuilder = UriComponentsBuilder.newInstance();
		
		userMessageController.setUserMessageService(userMessageService);
		
		when(userMessageService.findByPK(anyLong()).get()).thenReturn(userMessageTest);
		when(userMessageService.findAll()).thenReturn(userMessageListTest);
		
		when(messageSource.getMessage(anyString(), any(Object[].class), anyObject())).thenReturn(MESSAGE_SOURCE_VALUE);
		
		userMessageController.setMessageSource(messageSource);
	}

	@Test
	public final void shouldFindAllNullList() {
		when(userMessageService.findAll()).thenReturn(null);
		
		final ResponseEntity<List<UserMessage>> responseEntity = userMessageController.findAll();
		
		assertEquals(HttpStatus.NOT_FOUND,responseEntity.getStatusCode());
		assertNull(responseEntity.getBody());
	}
	
	@Test
	public final void shouldFindAllEmptyList() {
		when(userMessageService.findAll()).thenReturn(new ArrayList<UserMessage>());
		
		final ResponseEntity<List<UserMessage>> responseEntity = userMessageController.findAll();
		
		assertEquals(HttpStatus.NOT_FOUND,responseEntity.getStatusCode());
		assertNull(responseEntity.getBody());
	}
	
	@Test
	public final void shouldFindAll() {
		final ResponseEntity<List<UserMessage>> responseEntity = userMessageController.findAll();
		
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
		assertEquals(userMessageListTest,responseEntity.getBody());
	}
	
	@Test
	public final void shouldFindByPKNullValue() {
		when(userMessageService.findByPK(anyLong())).thenReturn(null);
		
		final ResponseEntity<UserMessage> responseEntity = (ResponseEntity<UserMessage>) userMessageController.findByPk(UserMessageConstant.TEST_USER_MESSAGE_1_ID,request);
		
		assertEquals(HttpStatus.NOT_FOUND,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	
	@Test
	public final void shouldFindByPK() {	
		final ResponseEntity<UserMessage> responseEntity = (ResponseEntity<UserMessage>) userMessageController.findByPk(UserMessageConstant.TEST_USER_MESSAGE_1_ID,request);
		
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
		assertEquals(userMessageTest,responseEntity.getBody());
	}
	
	@Test
	public final void shouldInsertExist() {
		final ResponseEntity<UserMessage> responseEntity = (ResponseEntity<UserMessage>) userMessageController.insert(userMessageTest,uriComponentsBuilder,request);
		
		assertEquals(HttpStatus.CONFLICT,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	
	@Test
	public final void shouldInsert() {
		when(userMessageService.findByPK(anyLong())).thenReturn(null);
		userMessageTest.setId(5L);
		
		final ResponseEntity<UserMessage> responseEntity = (ResponseEntity<UserMessage>) userMessageController.insert(userMessageTest,uriComponentsBuilder,request);
		
		assertEquals(HttpStatus.CREATED,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getHeaders());
	}
	
	@Test
	public final void shouldUpdateNotExist() {
		when(userMessageService.findByPK(anyLong())).thenReturn(null);
		
		final ResponseEntity<UserMessage> responseEntity = (ResponseEntity<UserMessage>) userMessageController.update(UserMessageConstant.TEST_USER_MESSAGE_1_ID.longValue(), userMessageTest,request);
				
		assertEquals(HttpStatus.NOT_FOUND,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	
	@Test
	public final void shouldUpdate() {
		final ResponseEntity<UserMessage> responseEntity = (ResponseEntity<UserMessage>) userMessageController.update(UserMessageConstant.TEST_USER_MESSAGE_1_ID.longValue(), userMessageTest,request);
				
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	
	@Test
	public final void shouldDeleteNotExist() {
		when(userMessageService.findByPK(anyLong())).thenReturn(null);
		
		final ResponseEntity<UserMessage> responseEntity = (ResponseEntity<UserMessage>) userMessageController.delete(UserMessageConstant.TEST_USER_MESSAGE_1_ID.longValue(), request);
				
		assertEquals(HttpStatus.NOT_FOUND,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	
	@Test
	public final void shouldDelete() {
		final ResponseEntity<UserMessage> responseEntity = (ResponseEntity<UserMessage>) userMessageController.delete(UserMessageConstant.TEST_USER_MESSAGE_1_ID.longValue(), request);
				
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
		assertNull(responseEntity.getBody());
	}
	
}
