package com.acme.message.api.restful.crud.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.acme.message.api.restful.crud.entity.UserMessage;
import com.acme.message.api.restful.crud.factory.dummy.DummyUserMessageDataFactory;
import com.acme.message.api.restful.crud.repository.UserMessageRepository;
import com.acme.message.api.restful.crud.service.impl.UserMessageServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserMessageServiceCase2Test {

	@Mock
	private UserMessageRepository userMessageRepository;

	//@InjectMocks
	private UserMessageServiceImpl userMessageService;
	
	private UserMessage userMessageTest;
	
	private List<UserMessage> expectedUserMessageList;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		
		userMessageService = new UserMessageServiceImpl();
		
		userMessageTest = DummyUserMessageDataFactory.createSampleDefault();
		
		List<UserMessage> expectedUserMessageList = Arrays.asList(userMessageTest);
		
		System.out.println("INIT expectedUserMessageList :: "+expectedUserMessageList);

		when(userMessageRepository.findAll()).thenReturn(expectedUserMessageList);
		
		userMessageService.setUserMessageRepository(userMessageRepository);
	}
	
	@Test
    public void whenCallFindAll_thenReturnElementList() {
        List<UserMessage> result = userMessageService.findAll();
        
        System.out.println("Result :: "+result);
        System.out.println("expectedUserMessageList :: "+expectedUserMessageList);

        assertThat(result).isEqualTo(expectedUserMessageList);
    }

}
