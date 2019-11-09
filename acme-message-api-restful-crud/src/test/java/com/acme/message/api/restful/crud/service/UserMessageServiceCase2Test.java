package com.acme.message.api.restful.crud.service;

import static org.mockito.Mockito.doReturn;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.acme.message.api.restful.crud.dao.UserMessageRepository;
import com.acme.message.api.restful.crud.entity.UserMessage;
import com.acme.message.api.restful.crud.factory.dummy.DummyUserMessageDataFactory;

@RunWith(MockitoJUnitRunner.class)
public class UserMessageServiceCase2Test {

	@Mock
	private UserMessageRepository userMessageRepository;

	@InjectMocks
	private UserMessageService userMessageService;
	
	private UserMessage userMessageTest;
	
	private List<UserMessage> expectedUserMessageList;
	
	@Before
	public void init() {
		userMessageTest = DummyUserMessageDataFactory.createSampleDefault();
		
		List<UserMessage> expectedUserMessageList = Arrays.asList(userMessageTest);

        doReturn(expectedUserMessageList).when(userMessageRepository).findAll();
	}
	
	@Test
    public void whenFindAll_thenReturnUserMessageList() {
        List<UserMessage> actualProducts = userMessageService.findAll();

        assertThat(actualProducts).isEqualTo(expectedUserMessageList);
    }

}
