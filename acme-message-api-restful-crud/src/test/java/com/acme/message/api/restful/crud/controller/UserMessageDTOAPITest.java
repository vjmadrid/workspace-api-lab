package com.acme.message.api.restful.crud.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
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
import com.acme.message.api.restful.crud.dto.UserMessageDTO;
import com.acme.message.api.restful.crud.entity.UserMessage;
import com.acme.message.api.restful.crud.factory.dummy.DummyUserMessageDTODataFactory;
import com.acme.message.api.restful.crud.factory.dummy.DummyUserMessageDataFactory;
import com.acme.message.api.restful.crud.mapper.UserMessageMapper;
import com.acme.message.api.restful.crud.service.UserMessageService;

public class UserMessageDTOAPITest {
	
	private UserMessageDTOAPI userMessageDTOAPI;

	private UserMessageService userMessageService;
	
	private List<UserMessage> userMessageListTest;
	
	private List<UserMessageDTO> userMessageDTOListTest;
	
	private UserMessage userMessageTest;
	
	private UserMessageDTO userMessageDTOTest;
	
	private UserMessageMapper userMessageMapper;
	
	@Before
	public final void setUp() throws Exception {
		userMessageTest = DummyUserMessageDataFactory.createSampleDefault();
		userMessageListTest = DummyUserMessageDataFactory.createSampleList();
		
		userMessageDTOTest = DummyUserMessageDTODataFactory.createSampleDefault();
		userMessageDTOListTest  = DummyUserMessageDTODataFactory.createSampleList();

		userMessageDTOAPI = spy(new UserMessageDTOAPI());
		userMessageService = mock(UserMessageService.class);
		userMessageMapper = mock(UserMessageMapper.class);
		
		when(userMessageService.findByPK(anyLong())).thenReturn(Optional.of(userMessageTest));
		when(userMessageService.findAll()).thenReturn(userMessageListTest);
		
		when(userMessageMapper.toUserMessageDTO(any(UserMessage.class))).thenReturn(userMessageDTOTest);
		when(userMessageMapper.toUserMessage(any(UserMessageDTO.class))).thenReturn(userMessageTest);
		when(userMessageMapper.toUserMessageDTOList(any())).thenReturn(userMessageDTOListTest);
		
		userMessageDTOAPI.setUserMessageService(userMessageService);
		userMessageDTOAPI.setUserMessageMapper(userMessageMapper);
	}

	@Test
	public final void whenCallFindAllAndServiceNullInvalid_thenReturnHttpOkAndBody() {
		when(userMessageService.findAll()).thenReturn(null);
		
		final ResponseEntity<List<UserMessageDTO>> responseEntity = userMessageDTOAPI.findAll();
		
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	
	@Test
	public final void whenCallFindAllAndServiceValid_thenReturnHttpOkAndBody() {
		final ResponseEntity<List<UserMessageDTO>> responseEntity = userMessageDTOAPI.findAll();
		
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	
	@Test
	public final void whenCallFindByIdAndServiceValid_thenReturnHttpOkAndBody() {
		final ResponseEntity<UserMessageDTO> responseEntity = (ResponseEntity<UserMessageDTO>) userMessageDTOAPI.findById(UserMessageConstant.TEST_USER_MESSAGE_1_ID);
		
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	
	@Test
	public final void whenCallCreateAndServiceValid_thenReturnHttpCreatedAndBody() {
		final ResponseEntity<UserMessageDTO> responseEntity = (ResponseEntity<UserMessageDTO>) userMessageDTOAPI.create(userMessageDTOTest);
		
		assertEquals(HttpStatus.CREATED,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	
	@Test
	public final void whenCallUpdateAndServiceValid_thenReturnHttpAcceptedAndBody() {
		final ResponseEntity<UserMessageDTO> responseEntity = (ResponseEntity<UserMessageDTO>) userMessageDTOAPI.update(UserMessageConstant.TEST_USER_MESSAGE_1_ID,userMessageDTOTest);
		
		assertEquals(HttpStatus.ACCEPTED,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	
	@Test
	public final void whenCallDeleteAndServiceValid_thenReturnHttpAcceptedAndEmptyBody() {
		final ResponseEntity<UserMessageDTO> responseEntity = (ResponseEntity<UserMessageDTO>) userMessageDTOAPI.delete(UserMessageConstant.TEST_USER_MESSAGE_1_ID);
		
		assertEquals(HttpStatus.ACCEPTED,responseEntity.getStatusCode());
		assertNull(responseEntity.getBody());
	}
		
}
