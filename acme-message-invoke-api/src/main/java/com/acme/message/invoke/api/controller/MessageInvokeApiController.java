package com.acme.message.invoke.api.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.acme.message.invoke.api.constant.MessageInvokeApiConstant;
import com.acme.message.invoke.api.service.MessageService;

@RestController
@RequestMapping(MessageInvokeApiConstant.MAPPING)
public class MessageInvokeApiController {
	
	public static final Logger LOG = LoggerFactory.getLogger(MessageInvokeApiController.class);
	
	@Autowired
	private MessageService messageService;

    @RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
    public String getMessage() {
    	LOG.info("Get Message ...");
    	
    	String message = messageService.generate();
    	LOG.info(" [*] message :: {}",message);
    	
    	return message;
    }
}
