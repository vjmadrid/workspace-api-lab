package com.acme.message.api.restful.crud.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.acme.message.api.restful.crud.constant.UserMessageConstant;
import com.acme.message.api.restful.crud.dto.UserMessageDTO;

public class UserMessageDTODataFactoryTest {

	@Before
	public void init() {
	}

	@Test
	public void shouldCreate() {
		UserMessageDTO result = UserMessageDTODataFactory.create(UserMessageConstant.TEST_USER_MESSAGE_1_ID,UserMessageConstant.TEST_USER_MESSAGE_1_DESCRIPTION, UserMessageConstant.TEST_USER_MESSAGE_1_VIP);
		
		assertNotNull(result);
		assertEquals(UserMessageConstant.TEST_USER_MESSAGE_1_ID,result.getId());
		assertEquals(UserMessageConstant.TEST_USER_MESSAGE_1_DESCRIPTION,result.getDescription());
		assertFalse(result.isVip());
	}
	
	@Test
	public void shouldCreateDefaultConstructor() {
		assertNotNull(new UserMessageDTODataFactory());
	}

}