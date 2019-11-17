package com.acme.message.api.restful.crud.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.acme.message.api.restful.crud.config.constant.DefaultSpringConfigConstant;
import com.acme.message.api.restful.crud.constant.UserMessageConstant;
import com.acme.message.api.restful.crud.entity.UserMessage;
import com.acme.message.api.restful.crud.exception.MessageApiCrudException;
import com.acme.message.api.restful.crud.factory.dummy.DummyUserMessageDataFactory;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(profiles = { DefaultSpringConfigConstant.SPRING_PROFILE_DEVELOPMENT})
//@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class UserMessageOperationServiceCase2Test {

	public int TEST_NUM_MESSAGES_VIP_LIQUIBASE = 1;

	@Autowired
	private UserMessageOperationService userMessageOperationService;
	
	@Autowired
	private UserMessageService userMessageService;

	private UserMessage userMessageTest;

	@Before
	public void init() {
		userMessageTest = DummyUserMessageDataFactory.createSampleDefault();
    	userMessageTest.setId(null);
	}

	@Test
	public void whenCallFindAllVips_thenReturnElementVipList() {
		List<UserMessage> result = userMessageOperationService.findAllVips();

		assertThat(result).hasSize(TEST_NUM_MESSAGES_VIP_LIQUIBASE);
		assertThat(result.get(0).getId()).isEqualTo(1L);
	}
	
	@Test
    public void whenCallDelete_thenDeleteElement() throws MessageApiCrudException {
		final Optional<UserMessage> foundOrigin = userMessageService.findByPK(UserMessageConstant.TEST_USER_MESSAGE_1_ID);
		UserMessage valueFoundOrigin = foundOrigin.get();
		
		assertNotNull(valueFoundOrigin);
		assertNull(valueFoundOrigin.getDeletedDate());
		
		userMessageOperationService.deleteLogical(UserMessageConstant.TEST_USER_MESSAGE_1_ID);
		
		final Optional<UserMessage> found = userMessageService.findByPK(UserMessageConstant.TEST_USER_MESSAGE_1_ID);
		UserMessage valueFound = found.get();
		
		assertNotNull(valueFound);
		assertNotNull(valueFound.getDeletedDate());
    }


}
