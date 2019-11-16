package com.acme.message.api.restful.crud.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.acme.message.api.restful.crud.config.MessageApiCrudConfig;
import com.acme.message.api.restful.crud.constant.UserMessageConstant;
import com.acme.message.api.restful.crud.entity.UserMessage;
import com.acme.message.api.restful.crud.factory.dummy.DummyUserMessageDataFactory;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { MessageApiCrudConfig.class })
//@ActiveProfiles(profiles = { DefaultSpringConfigConstant.SPRING_PROFILE_DEVELOPMENT})
//@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class UserMessageRepository1NoDirtyTest {
	
	public int TEST_NUM_MESSAGES = UserMessageConstant.TEST_NUM_MESSAGES;

	@Autowired
	private UserMessageRepository userMessageRepository;

	private UserMessage userMessageTest;

	@Before
	public void init() {
		userMessageTest = DummyUserMessageDataFactory.createSampleDefault();
	}

	@Test
	public void whenCallFindAll_thenReturnElementList() {
		final List<UserMessage> result = userMessageRepository.findAll();

		assertNotNull(result);
		assertThat(result).hasSize(TEST_NUM_MESSAGES);
	}

	@Test
	public void whenCallFindById_thenReturnOptionalElementWithId() {
		final Optional<UserMessage> result = userMessageRepository.findById(UserMessageConstant.TEST_USER_MESSAGE_2_ID);
		
		UserMessage value = result.get();
		
		assertNotNull(value);
		assertEquals(UserMessageConstant.TEST_USER_MESSAGE_2_ID, value.getId());
	}

	@Test
	public void whenCallDelete_thenDeleteElementPreviouslySearched() {
		final Optional<UserMessage> origin = userMessageRepository.findById(UserMessageConstant.TEST_USER_MESSAGE_1_ID);

		assertNotNull(origin.get());
		
		userMessageRepository.delete(origin.get());
		
		final UserMessage deleted = userMessageRepository.findById(UserMessageConstant.TEST_USER_MESSAGE_1_ID).orElse(null);
		assertNull(deleted);
	}
		
	@Test
	public void whenCallSave_thenSaveElement() {
		final Long newID = Long.valueOf((UserMessageConstant.TEST_NUM_MESSAGES+1));
		
		userMessageTest.setId(null);
		userMessageTest.setDescription("TEST");
		
		userMessageRepository.save(userMessageTest);
		
		final Optional<UserMessage> origin = userMessageRepository.findById(newID);
		UserMessage value = origin.get();
		
		assertNotNull(value);
		assertEquals("TEST", value.getDescription());	
		
		userMessageRepository.delete(value);
	}
	
	@Test
	public void whenCallUpdate_thenUpdateElement() {
		final Optional<UserMessage> origin = userMessageRepository.findById(UserMessageConstant.TEST_USER_MESSAGE_2_ID);
		UserMessage originValue = origin.get();
		
		originValue.setDescription(null);
		
		userMessageRepository.save(originValue);
		
		final Optional<UserMessage> result = userMessageRepository.findById(UserMessageConstant.TEST_USER_MESSAGE_2_ID);
		UserMessage resultValue = result.get();
		
		assertNotNull(resultValue);
		assertNull(resultValue.getDescription());
	}

}