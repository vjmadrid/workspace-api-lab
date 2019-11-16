package com.acme.message.api.restful.crud.service;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import com.acme.message.api.restful.crud.entity.UserMessage;
import com.acme.message.api.restful.crud.factory.dummy.DummyUserMessageDataFactory;
import com.acme.message.api.restful.crud.repository.UserMessageRepository;
import com.acme.message.api.restful.crud.service.impl.UserMessageServiceImpl;


public class UserMessageServiceCase1Test {
	
	private UserMessageServiceImpl userMessageService;
	
	private UserMessageRepository userMessageRepository;
	
	private UserMessage userMessageTest;

	@Before
	public void init() {
		userMessageTest = DummyUserMessageDataFactory.createSampleDefault();
				
		userMessageService = new UserMessageServiceImpl();
		userMessageRepository = mock(UserMessageRepository.class);
		
		when(userMessageRepository.findAll()).thenReturn(DummyUserMessageDataFactory.createSampleList());
		when(userMessageRepository.findById(anyLong())).thenReturn(Optional.of(userMessageTest));
		
		userMessageService.setUserMessageRepository(userMessageRepository);
	}
	
	@Test
	public void whenCallFindAll_ThenInvokeTheDaoMethod() {
		userMessageService.findAll();
		verify(userMessageRepository).findAll();
	}
	
	@Test
	public void whenCallFindByPK_ThenInvokeTheDaoMethod() {
		userMessageService.findByPK(userMessageTest.getId());
		verify(userMessageRepository).findById(userMessageTest.getId());
	}
	
	@Test
	public void whenCallInsert_ThenInvokeTheDaoMethod() {
		userMessageService.insert(userMessageTest);
		verify(userMessageRepository).save(userMessageTest);
	}
		
	@Test
	public void whenCallUpdate_ThenInvokeTheDaoMethod() {
		userMessageService.update(userMessageTest);
		verify(userMessageRepository).save(userMessageTest);
	}

	@Test
	public void whenCallDelete_ThenInvokeTheDaoMethod() {
		userMessageService.delete(userMessageTest);
		verify(userMessageRepository).delete(userMessageTest);
	}

}
