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
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

public class UserMessageControllerTest {
	
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
		
		when(userMessageService.findByPK(anyLong())).thenReturn(Optional.of(userMessageTest));
		when(userMessageService.findAll()).thenReturn(userMessageListTest);
		
		when(messageSource.getMessage(anyString(), any(Object[].class), anyObject())).thenReturn(MESSAGE_SOURCE_VALUE);
		
		userMessageController.setMessageSource(messageSource);
	}

	@Test
	public final void whenCallFindAllAndServiceIsNull_thenReturnHttpNotFoundAndEmptyBody() {
		when(userMessageService.findAll()).thenReturn(null);
		
		final ResponseEntity<List<UserMessage>> responseEntity = userMessageController.findAll();
		
		assertEquals(HttpStatus.NOT_FOUND,responseEntity.getStatusCode());
		assertNull(responseEntity.getBody());
	}
	
	@Test
	public final void whenCallFindAllAndServiceIsEmpty_thenReturnHttpNotFoundAndEmptyBody() {
		when(userMessageService.findAll()).thenReturn(Collections.emptyList());
		// Option 1 : Use new ArrayList<UserMessage>()
		// Option 2 : Collections.emptyList()
		
		final ResponseEntity<List<UserMessage>> responseEntity = userMessageController.findAll();
		
		assertEquals(HttpStatus.NOT_FOUND,responseEntity.getStatusCode());
		assertNull(responseEntity.getBody());
	}
	
	@Test
	public final void whenCallFindAllAndServiceIsNormal_thenReturnHttpOkAndElementListBody() {
		final ResponseEntity<List<UserMessage>> responseEntity = userMessageController.findAll();
		
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
		assertEquals(userMessageListTest,responseEntity.getBody());
	}
	
	@Test
	public final void whenCallFindByPKAndServiceIsNull_thenReturnHttpNotFoundAndEmptyBody() {
		userMessageTest = null;
		when(userMessageService.findByPK(anyLong())).thenReturn(Optional.ofNullable(userMessageTest));
		
		final ResponseEntity<UserMessage> responseEntity = (ResponseEntity<UserMessage>) userMessageController.findByPk(UserMessageConstant.TEST_USER_MESSAGE_1_ID,request);
		
		assertEquals(HttpStatus.NOT_FOUND,responseEntity.getStatusCode());
		assertNull(responseEntity.getBody());
	}
	
	@Test
	public final void whenCallFindByPKAndServiceIsInvalid_thenReturnHttpNotFoundAndBodyWithMessage() {
		userMessageTest.setId(null);
		when(userMessageService.findByPK(anyLong())).thenReturn(Optional.of(userMessageTest));
		
		final ResponseEntity<UserMessage> responseEntity = (ResponseEntity<UserMessage>) userMessageController.findByPk(UserMessageConstant.TEST_USER_MESSAGE_1_ID,request);
		
		assertEquals(HttpStatus.NOT_FOUND,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	
	@Test
	public final void whenCallFindByPKAndServiceIsNormal_thenReturnHttpOkAndElementBody() {	
		final ResponseEntity<UserMessage> responseEntity = (ResponseEntity<UserMessage>) userMessageController.findByPk(UserMessageConstant.TEST_USER_MESSAGE_1_ID,request);
		
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
		assertEquals(userMessageTest,responseEntity.getBody());
	}
	
	@Test
	public final void whenCallInsertAndServiceIsExist_thenReturnHttpConflictAndEmptyBody() {
		System.out.println("****** whenCallInsertAndServiceIsExist_thenReturnHttpConflictAndEmptyBody");
		final ResponseEntity<UserMessage> responseEntity = (ResponseEntity<UserMessage>) userMessageController.insert(userMessageTest,uriComponentsBuilder,request);
		
		assertEquals(HttpStatus.CONFLICT,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	
	@Test
	public final void whenCallInsertAndServiceIsValid_thenReturnHttpCreatedAndHeaders() {
		UserMessage userMessageLocalTest = null;
		when(userMessageService.findByPK(anyLong())).thenReturn(Optional.ofNullable(userMessageLocalTest));

		final ResponseEntity<UserMessage> responseEntity = (ResponseEntity<UserMessage>) userMessageController.insert(userMessageTest,uriComponentsBuilder,request);
		
		assertEquals(HttpStatus.CREATED,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getHeaders());
	}
	
	@Test
	public final void whenCallUpdateAndServiceNotExist_thenReturnHttpNotFoundAndElementBody() {
		UserMessage userMessageLocalTest = null;
		when(userMessageService.findByPK(anyLong())).thenReturn(Optional.ofNullable(userMessageLocalTest));
		
		final ResponseEntity<UserMessage> responseEntity = (ResponseEntity<UserMessage>) userMessageController.update(UserMessageConstant.TEST_USER_MESSAGE_1_ID.longValue(), userMessageTest,request);
				
		assertEquals(HttpStatus.NOT_FOUND,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	
	@Test
	public final void whenCallUpdateAndServiceValid_thenReturnHttpOKFoundAndEmptyBody() {
		final ResponseEntity<UserMessage> responseEntity = (ResponseEntity<UserMessage>) userMessageController.update(UserMessageConstant.TEST_USER_MESSAGE_1_ID.longValue(), userMessageTest,request);
				
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	
	@Test
	public final void whenCallDeleteAndServiceNotExist_thenReturnHttpNotFoundAndElementBody() {
		UserMessage userMessageLocalTest = null;
		when(userMessageService.findByPK(anyLong())).thenReturn(Optional.ofNullable(userMessageLocalTest));
		
		final ResponseEntity<UserMessage> responseEntity = (ResponseEntity<UserMessage>) userMessageController.delete(UserMessageConstant.TEST_USER_MESSAGE_1_ID.longValue(), request);
				
		assertEquals(HttpStatus.NOT_FOUND,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	
	
	@Test
	public final void whenCallDeleteAndServiceValid_thenReturnHttpOKFoundAndEmptyBody() {
		final ResponseEntity<UserMessage> responseEntity = (ResponseEntity<UserMessage>) userMessageController.delete(UserMessageConstant.TEST_USER_MESSAGE_1_ID.longValue(), request);
				
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
		assertNull(responseEntity.getBody());
	}
	
}
