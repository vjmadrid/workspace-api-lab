package com.acme.message.api.restful.crud.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.acme.message.api.restful.crud.constant.UserMessageConstant;
import com.acme.message.api.restful.crud.entity.UserMessage;
import com.acme.message.api.restful.crud.factory.dummy.DummyUserMessageDataFactory;
import com.acme.message.api.restful.crud.repository.UserMessageRepository;
import com.acme.message.api.restful.crud.service.impl.UserMessageServiceImpl;

public class UserMessageServiceCase2Test {

	private UserMessageRepository userMessageRepository;

	private UserMessageServiceImpl userMessageService;
	
	private UserMessage userMessageTest;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		
		userMessageTest = DummyUserMessageDataFactory.createSampleDefault();
		
		List<UserMessage> expectedUserMessageList = Arrays.asList(userMessageTest);
		
		userMessageService = new UserMessageServiceImpl();
		userMessageRepository = mock(UserMessageRepository.class);
		
		when(userMessageRepository.findAll()).thenReturn(expectedUserMessageList);
		when(userMessageRepository.findById(anyLong())).thenReturn(Optional.of(userMessageTest));
		
		userMessageService.setUserMessageRepository(userMessageRepository);
	}
	
	@Test
    public void whenCallFindAll_thenReturnElementList() {
        List<UserMessage> result = userMessageService.findAll();
        
        assertThat(result).hasSize(1);
        assertThat(result.get(0)).isEqualTo(userMessageTest);
    }
	
	@Test
    public void whenCallFindByPK_thenReturnElementWithId() {
        final Optional<UserMessage> result = userMessageService.findByPK(UserMessageConstant.TEST_USER_MESSAGE_1_ID);
        
        UserMessage value = result.get();
        
        assertNotNull(value);
		assertEquals(UserMessageConstant.TEST_USER_MESSAGE_1_ID, value.getId());
    }
	
	@Test
    public void whenCallInsert_thenReturnElement() {
		when(userMessageRepository.save(Mockito.any(UserMessage.class))).thenReturn(userMessageTest);
		
        UserMessage result = userMessageService.insert(userMessageTest);
        
        assertNotNull(result);
		assertEquals(UserMessageConstant.TEST_USER_MESSAGE_1_ID, result.getId());
    }
	
	@Test
    public void whenCallUpdate_thenReturnElementUpdated() {
		when(userMessageRepository.save(Mockito.any(UserMessage.class))).thenReturn(userMessageTest);
		
        UserMessage result = userMessageService.update(userMessageTest);
        
        assertNotNull(result);
		assertEquals(UserMessageConstant.TEST_USER_MESSAGE_1_ID, result.getId());
    }
	
	@Test
    public void whenCallDelete_thenDelteteElement() {
		userMessageService.delete(userMessageTest);
		verify(userMessageRepository).delete(userMessageTest);
    }

}
