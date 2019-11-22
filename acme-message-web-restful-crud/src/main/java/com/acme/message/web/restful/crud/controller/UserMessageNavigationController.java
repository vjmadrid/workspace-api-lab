package com.acme.message.web.restful.crud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.acme.message.web.restful.crud.constant.UserMessageNavigationConstant;

@Controller
public class UserMessageNavigationController {

	public static final Logger LOG = LoggerFactory.getLogger(UserMessageNavigationController.class);

	@GetMapping(UserMessageNavigationConstant.MAPPING)
	public String userMessages() {
		LOG.info("Navigation UserMessages...");
		
		return UserMessageNavigationConstant.PAGE_USERMESSAGES;
	}

	

}