package com.acme.message.api.restful.crud.dao;

import org.springframework.data.repository.CrudRepository;

import com.acme.message.api.restful.crud.entity.UserMessage;

public interface UserMessageRepository extends CrudRepository<UserMessage, Long> {
	
}
