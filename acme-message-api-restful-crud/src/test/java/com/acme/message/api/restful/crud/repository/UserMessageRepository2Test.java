package com.acme.message.api.restful.crud.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import com.acme.message.api.restful.crud.constant.UserMessageConstant;
import com.acme.message.api.restful.crud.entity.UserMessage;
import com.acme.message.api.restful.crud.factory.dummy.DummyUserMessageDataFactory;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class UserMessageRepository2Test {
	
	public int TEST_NUM_MESSAGES = UserMessageConstant.TEST_NUM_MESSAGES;
	
	@Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserMessageRepository userMessageRepository;
    
    private UserMessage userMessageTest;
    
    @Before
    public void setUp(){
    	userMessageTest = DummyUserMessageDataFactory.createSampleDefault();
    	userMessageTest.setId(null);
    	
        testEntityManager.persist(userMessageTest);
        TEST_NUM_MESSAGES++;
    }

    @Test
    public void whenCallFindAll_thenReturnElementList() {
        final List<UserMessage> result = userMessageRepository.findAll();

        assertNotNull(result);	
        assertThat(result).hasSize(TEST_NUM_MESSAGES);
    }
    
    @Test
    public void whenCallFindById_thenReturnOptionalElementWithId() {
        final UserMessage result = userMessageRepository.findById(UserMessageConstant.TEST_USER_MESSAGE_1_ID).get();

        assertNotNull(result);	
        assertThat(result.getDescription()).isEqualTo(UserMessageConstant.TEST_USER_MESSAGE_1_DESCRIPTION);
    }
    
    @Test
	public void whenCallDelete_thenDeleteElementPreviouslySearched() {
		final UserMessage origin = userMessageRepository.findById(UserMessageConstant.TEST_USER_MESSAGE_1_ID).get();

		userMessageRepository.delete(origin);
		
		final UserMessage deleted = userMessageRepository.findById(UserMessageConstant.TEST_USER_MESSAGE_1_ID).orElse(null);
		assertNull(deleted);
	}
    
    @Test
	public void whenCallSave_thenSaveElement() {
		final Long newID = Long.valueOf((UserMessageConstant.TEST_NUM_MESSAGES+1));
		
		userMessageTest.setId(null);
		userMessageTest.setDescription("TEST");
		
		userMessageRepository.save(userMessageTest);
		
		final UserMessage origin = userMessageRepository.findById(newID).get();
		
		assertNotNull(origin);
		assertEquals("TEST", origin.getDescription());	
		
		userMessageRepository.delete(origin);
	}
	
	@Test
	public void whenCallUpdate_thenUpdateElement() {
		final UserMessage origin = userMessageRepository.findById(UserMessageConstant.TEST_USER_MESSAGE_2_ID).get();
		
		origin.setDescription(null);
		
		userMessageRepository.save(origin);
		
		final UserMessage result = userMessageRepository.findById(UserMessageConstant.TEST_USER_MESSAGE_2_ID).get();

		assertNotNull(result);
		assertNull(result.getDescription());
	}

    

}
