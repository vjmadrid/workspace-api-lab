package com.acme.message.api.restful.crud.dao;

import static org.assertj.core.api.Assertions.assertThat;

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
public class UserMessageRepositoryTest {
	
	@Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserMessageRepository userMessageRepository;
    
    private UserMessage userMessageTest;
    
    @Before
    public void setUp(){
    	//Resolve problem ID Sequence
    	userMessageTest = DummyUserMessageDataFactory.createSampleDefault();
    	userMessageTest.setId(null);
    	
        testEntityManager.persist(userMessageTest);
    }

    @Test
    public void whenFindById_thenReturnUserMessage() {
        final UserMessage userMessage = userMessageRepository.findById(1L).get();

        assertThat(userMessage.getDescription()).isEqualTo(UserMessageConstant.TEST_USER_MESSAGE_1_DESCRIPTION);
    }

    @Test
    public void whenFindAll_thenReturnUserMessageList() {
        final List<UserMessage> userMessagesList = userMessageRepository.findAll();

        assertThat(userMessagesList).hasSize(1);
    }

}
