package com.acme.message.api.restful.crud.util.converter;

import static org.junit.Assert.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.acme.message.api.restful.crud.entity.UserMessage;
import com.acme.message.api.restful.crud.factory.dummy.DummyUserMessageDataFactory;

public class CollectionConverterTest {

	private UserMessage userMessageTest;
	
	private List<UserMessage> userMessageList;
	
	@Before
	public void init() {
		userMessageTest = DummyUserMessageDataFactory.createSampleDefault();
		userMessageList = DummyUserMessageDataFactory.createSampleList();
	}

	@Test
	public void whenCallToListWithNull_ThenReturnEmptyList() {
		List<UserMessage> result = CollectionConverter.toList(null);
		
		assertNotNull(result);
		assertThat(result).isEmpty();
	}
	
	@Test
	public void whenCallToListWithOneElement_ThenReturnListWithOneElement() {
		List<UserMessage> oneElementList = Arrays.asList(userMessageTest);
		
		
		List<UserMessage> result = CollectionConverter.toList(oneElementList);
		
		assertNotNull(result);
		assertThat(result).hasSize(1);
		
		assertThat(result.get(0)).isEqualTo(userMessageTest);
	}

	@Test
	public void whenCallToListWithElementList_ThenReturnListWithElementList() {
		List<UserMessage> result = CollectionConverter.toList(userMessageList);
		
		assertNotNull(result);
		assertThat(result).hasSize(userMessageList.size());
		
		assertThat(result).isEqualTo(userMessageList);
	}

	

}