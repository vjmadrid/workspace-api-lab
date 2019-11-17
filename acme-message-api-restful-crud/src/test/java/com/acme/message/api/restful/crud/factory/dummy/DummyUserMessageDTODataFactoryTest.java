package com.acme.message.api.restful.crud.factory.dummy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.acme.message.api.restful.crud.constant.UserMessageConstant;
import com.acme.message.api.restful.crud.dto.UserMessageDTO;

public class DummyUserMessageDTODataFactoryTest {

	@Before
	public void init() {
	}

	@Test
	public void shouldCreateSampleDefault() {
		assertNotNull(DummyUserMessageDTODataFactory.createSampleDefault());
	}
	
	@Test
	public void shouldCreateSampleUserMap() {
		Map<Long, UserMessageDTO> result = DummyUserMessageDTODataFactory.createSampleMap();
		
		assertNotNull(result);
		assertEquals(UserMessageConstant.TEST_NUM_MESSAGES,result.size());
	}
	
	@Test
	public void shouldCreateSampleUserList() {
		List<UserMessageDTO> result = DummyUserMessageDTODataFactory.createSampleList();
		
		assertNotNull(result);
		assertEquals(UserMessageConstant.TEST_NUM_MESSAGES,result.size());
	}
	
	@Test
	public void shouldCreateDefaultConstructor() {
		assertNotNull(new DummyUserMessageDTODataFactory());
	}

}