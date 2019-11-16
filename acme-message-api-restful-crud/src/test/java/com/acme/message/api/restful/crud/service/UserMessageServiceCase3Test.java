package com.acme.message.api.restful.crud.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.acme.message.api.restful.crud.entity.UserMessage;
import com.acme.message.api.restful.crud.factory.dummy.DummyUserMessageDataFactory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMessageServiceCase3Test {

	@Autowired
	private UserMessageService userMessageService;
	
	private UserMessage userMessageTest;
	
	private List<UserMessage> expectedUserMessageList;
	
	@Before
	public void init() {
		userMessageTest = DummyUserMessageDataFactory.createSampleDefault();
		
		List<UserMessage> expectedUserMessageList = Arrays.asList(userMessageTest);

	}
	
	@Test
    public void whenFindAll_thenReturnUserMessageList() {
        List<UserMessage> actualProducts = userMessageService.findAll();

        assertThat(actualProducts).isEqualTo(expectedUserMessageList);
    }

}
