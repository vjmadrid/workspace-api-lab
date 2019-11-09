package com.acme.message.api.restful.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acme.message.api.restful.crud.entity.UserMessage;

public interface UserMessageRepository extends JpaRepository<UserMessage, Long> {
	
}
