package com.acme.message.web.restful.crud.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;

import org.junit.Before;
import org.junit.Test;

import com.acme.message.web.restful.crud.constant.UserMessageNavigationConstant;

public class UserMessageNavigationControllerTest {
	
	private UserMessageNavigationController userMessageNavigationController;


	@Before
	public final void setUp() throws Exception {
		userMessageNavigationController = spy(new UserMessageNavigationController());
	}

	@Test
	public final void whenCallFindAllAndServiceNullInvalid_thenReturnHttpOkAndEmptyBody() {
		String view = userMessageNavigationController.userMessages();
		
		assertEquals(UserMessageNavigationConstant.PAGE_USERMESSAGES, view);
	}
	
	
		
	
	
}
