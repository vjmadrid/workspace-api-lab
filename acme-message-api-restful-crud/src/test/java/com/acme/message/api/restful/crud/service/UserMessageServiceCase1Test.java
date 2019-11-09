package com.acme.message.api.restful.crud.service;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import com.acme.message.api.restful.crud.dao.UserMessageRepository;
import com.acme.message.api.restful.crud.entity.UserMessage;
import com.acme.message.api.restful.crud.factory.dummy.DummyUserMessageDataFactory;
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
		
		doReturn(DummyUserMessageDataFactory.createSampleList()).when(userMessageRepository).findAll();
		
		doReturn(userMessageTest).when(userMessageRepository).findById(anyLong());
		
		userMessageService.setUserMessageRepository(userMessageRepository);
	}
	
	@Test
	public void whenCallFindAllElementsThenInvokeTheDaoMethod() {
		userMessageService.findAll();
		verify(userMessageRepository).findAll();
	}
	
	@Test
	public void whenCallFindThenInvokeTheDaoMethod() {
		userMessageService.findByPK(userMessageTest.getId());
		verify(userMessageRepository).findById(userMessageTest.getId());
	}
	
	@Test
	public void whenCallInsertThenInvokeTheDaoMethod() {
		userMessageService.insert(userMessageTest);
		verify(userMessageRepository).save(userMessageTest);
	}
		
	@Test
	public void whenCallUpdateThenInvokeTheDaoMethod() {
		userMessageService.update(userMessageTest);
		verify(userMessageRepository).save(userMessageTest);
	}

	@Test
	public void whenCallRemoveThenInvokeTheDaoMethod() {
		userMessageService.delete(userMessageTest);
	}

}
