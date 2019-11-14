package com.acme.message.api.restful.crud.factory.dummy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.acme.message.api.restful.crud.constant.UserMessageConstant;
import com.acme.message.api.restful.crud.entity.UserMessage;
import com.acme.message.api.restful.crud.factory.dummy.DummyUserMessageDataFactory;

public class DummyUserMessageDataFactoryTest {

	@Before
	public void init() {
	}

	@Test
	public void shouldCreateSampleDefault() {
		assertNotNull(DummyUserMessageDataFactory.createSampleDefault());
	}

	@Test
	public void shouldCreateSampleUserMap() {
		Map<Long, UserMessage> result = DummyUserMessageDataFactory.createSampleMap();
		
		assertNotNull(result);
		assertEquals(UserMessageConstant.TEST_NUM_MESSAGES,result.size());
	}
	
	@Test
	public void shouldCreateSampleUserList() {
		List<UserMessage> result = DummyUserMessageDataFactory.createSampleList();
		
		assertNotNull(result);
		assertEquals(UserMessageConstant.TEST_NUM_MESSAGES,result.size());
	}
	
	@Test
	public void shouldCreateDefaultConstructor() {
		assertNotNull(new DummyUserMessageDataFactory());
	}

}