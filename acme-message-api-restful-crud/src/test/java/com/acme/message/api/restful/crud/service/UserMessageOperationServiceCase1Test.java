package com.acme.message.api.restful.crud.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.MockitoAnnotations;

import com.acme.message.api.restful.crud.constant.UserMessageConstant;
import com.acme.message.api.restful.crud.entity.UserMessage;
import com.acme.message.api.restful.crud.exception.MessageApiCrudException;
import com.acme.message.api.restful.crud.exception.enumerate.UserMessageTypeExceptionEnum;
import com.acme.message.api.restful.crud.factory.dummy.DummyUserMessageDataFactory;
import com.acme.message.api.restful.crud.repository.UserMessageRepository;
import com.acme.message.api.restful.crud.service.impl.UserMessageOperationServiceImpl;

public class UserMessageOperationServiceCase1Test {

	private UserMessageRepository userMessageRepository;

	private UserMessageOperationServiceImpl userMessageOperationService;
	
	private UserMessage userMessageTest;
	
	private List<UserMessage> userMessageList;
	
	@Rule 
    public ExpectedException expectedException = ExpectedException.none();
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		
		userMessageTest = DummyUserMessageDataFactory.createSampleDefault();
		userMessageList = DummyUserMessageDataFactory.createSampleList();
		
		userMessageOperationService = new UserMessageOperationServiceImpl();
		userMessageRepository = mock(UserMessageRepository.class);
		
		when(userMessageRepository.findAll()).thenReturn(userMessageList);
		when(userMessageRepository.findById(anyLong())).thenReturn(Optional.of(userMessageTest));
		
		userMessageOperationService.setUserMessageRepository(userMessageRepository);
	}
	
	@Test
    public void whenCallFindAll_thenReturnElementList() {
		userMessageList.get(0).setDeletedDate(new Date());
        List<UserMessage> result = userMessageOperationService.findAllVips();
        
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getDeletedDate()).isNotNull();
    }
	
	@Test
    public void whenCallDeleteLogicalWithRepositoryNull_thenReturnNotFoundException() throws MessageApiCrudException {
		expectedException.expect(MessageApiCrudException.class);
		expectedException.expectMessage(UserMessageTypeExceptionEnum.NOT_FOUND.name());
		
		UserMessage userMessageLocalTest = null;
		when(userMessageRepository.findById(anyLong())).thenReturn(Optional.ofNullable(userMessageLocalTest));
		
		userMessageOperationService.deleteLogical(UserMessageConstant.TEST_USER_MESSAGE_1_ID);
    }
	
	@Test
    public void whenCallDeleteLogicalWithRepositoryInvalid_thenReturnIsDeletedLogicalException() throws MessageApiCrudException {
		expectedException.expect(MessageApiCrudException.class);
		expectedException.expectMessage(UserMessageTypeExceptionEnum.IS_DELETED_LOGICAL.name());
		
		userMessageTest.setDeletedDate(new Date());
		
		userMessageOperationService.deleteLogical(UserMessageConstant.TEST_USER_MESSAGE_1_ID);
    }
	
	@Test
    public void whenCallDeleteLogicalWithRepositoryValid_thenDeleteElement() throws MessageApiCrudException {
		userMessageOperationService.deleteLogical(UserMessageConstant.TEST_USER_MESSAGE_1_ID);
    }
	
	

}
