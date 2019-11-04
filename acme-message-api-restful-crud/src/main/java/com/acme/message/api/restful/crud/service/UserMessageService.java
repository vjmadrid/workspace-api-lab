package com.acme.message.api.restful.crud.service;

import java.util.List;
import java.util.Optional;

import com.acme.message.api.restful.crud.entity.UserMessage;

public interface UserMessageService {

	List<UserMessage> findAll();
	
	Optional<UserMessage> findByPK(Long id);
	
	void insert(UserMessage villain);

	void update(UserMessage villain);
	
	void delete(UserMessage id);
	
}
