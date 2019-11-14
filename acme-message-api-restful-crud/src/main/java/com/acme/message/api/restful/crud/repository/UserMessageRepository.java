package com.acme.message.api.restful.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acme.message.api.restful.crud.entity.UserMessage;

@Repository
public interface UserMessageRepository extends JpaRepository<UserMessage, Long> {
	
}
