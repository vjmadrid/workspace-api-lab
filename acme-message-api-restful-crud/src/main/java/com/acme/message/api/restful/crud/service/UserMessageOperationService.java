package com.acme.message.api.restful.crud.service;

import java.util.List;

import com.acme.message.api.restful.crud.entity.UserMessage;
import com.acme.message.api.restful.crud.exception.MessageApiCrudException;

public interface UserMessageOperationService {

	List<UserMessage> findAllVips();
	
	void deleteLogical(Long id) throws MessageApiCrudException;
	
}
