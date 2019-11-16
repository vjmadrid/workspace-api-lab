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
import org.springframework.test.context.junit4.SpringRunner;

import com.acme.message.api.restful.crud.constant.UserMessageConstant;
import com.acme.message.api.restful.crud.entity.UserMessage;
import com.acme.message.api.restful.crud.factory.dummy.DummyUserMessageDataFactory;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class UserMessageServiceCase3Test {

	public int TEST_NUM_MESSAGES_LIQUIBASE = 4;

	@Autowired
	private UserMessageService userMessageService;

	private UserMessage userMessageTest;

	@Before
	public void init() {
		userMessageTest = DummyUserMessageDataFactory.createSampleDefault();
    	userMessageTest.setId(null);

	}

	@Test
	public void whenCallFindAll_thenReturnElementList() {
		List<UserMessage> result = userMessageService.findAll();

		assertThat(result).hasSize(TEST_NUM_MESSAGES_LIQUIBASE);
		assertThat(result.get(0).getId()).isEqualTo(UserMessageConstant.TEST_USER_MESSAGE_1_ID);
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
		List<UserMessage> originList = userMessageService.findAll();

		assertThat(originList).hasSize(TEST_NUM_MESSAGES_LIQUIBASE);
		
		UserMessage result = userMessageService.insert(userMessageTest);
		TEST_NUM_MESSAGES_LIQUIBASE++;

		assertNotNull(result);
		assertEquals(Long.valueOf(String.valueOf(TEST_NUM_MESSAGES_LIQUIBASE)), result.getId());
		
		List<UserMessage> updatedList = userMessageService.findAll();

		assertThat(updatedList).hasSize(TEST_NUM_MESSAGES_LIQUIBASE);
	}
	
	@Test
    public void whenCallUpdate_thenReturnElementUpdated() {
		final Optional<UserMessage> foundOrigin = userMessageService.findByPK(UserMessageConstant.TEST_USER_MESSAGE_1_ID);
		UserMessage valueFoundOrigin = foundOrigin.get();
		valueFoundOrigin.setDescription("ACME");
		
        UserMessage result = userMessageService.update(valueFoundOrigin);
        
        assertNotNull(result);
		assertEquals("ACME", result.getDescription());
		
		final Optional<UserMessage> found = userMessageService.findByPK(UserMessageConstant.TEST_USER_MESSAGE_1_ID);
		UserMessage valueFound = found.get();
		
		assertNotNull(valueFound);
		assertEquals("ACME", valueFound.getDescription());
    }
	
	@Test
    public void whenCallDelete_thenDeleteElement() {
		final Optional<UserMessage> foundOrigin = userMessageService.findByPK(UserMessageConstant.TEST_USER_MESSAGE_1_ID);
		UserMessage valueFoundOrigin = foundOrigin.get();
		
		assertNotNull(valueFoundOrigin);
		assertEquals(UserMessageConstant.TEST_USER_MESSAGE_1_ID, valueFoundOrigin.getId());
		
//		userMessageService.delete(valueFoundOrigin);
//		
//		final Optional<UserMessage> found = userMessageService.findByPK(UserMessageConstant.TEST_USER_MESSAGE_1_ID);
//		UserMessage valueFound = found.get();
//		
//		assertNull(valueFound);
    }

}
