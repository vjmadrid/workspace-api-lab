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
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.message.api.restful.crud.config.MessageApiCrudConfig;
import com.acme.message.api.restful.crud.config.constant.DefaultSpringConfigConstant;
import com.acme.message.api.restful.crud.constant.UserMessageConstant;
import com.acme.message.api.restful.crud.entity.UserMessage;
import com.acme.message.api.restful.crud.factory.dummy.DummyUserMessageDataFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		classes = { MessageApiCrudConfig.class },
		initializers = ConfigFileApplicationContextInitializer.class
)
@ActiveProfiles(profiles = { DefaultSpringConfigConstant.SPRING_PROFILE_LOCAL})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class UserMessageRepository1DirtyTest {
	
	public int TEST_NUM_MESSAGES = 4;

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
		assertThat(result).hasSizeLessThanOrEqualTo(TEST_NUM_MESSAGES);
	}

	@Test
	public void whenCallFindById_thenReturnOptionalElementWithId() {
		final Optional<UserMessage> result = userMessageRepository.findById(UserMessageConstant.TEST_USER_MESSAGE_1_ID);
		
		UserMessage value = result.get();
		
		assertNotNull(value);
		assertEquals(UserMessageConstant.TEST_USER_MESSAGE_1_ID, value.getId());
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
		userMessageTest.setId(null);
		userMessageTest.setDescription("TEST");
		
		UserMessage userMessageResult = userMessageRepository.save(userMessageTest);
		
		System.out.println("*********** userMessageResult ::"+userMessageResult);
		
		final Optional<UserMessage> origin = userMessageRepository.findById(userMessageResult.getId());
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