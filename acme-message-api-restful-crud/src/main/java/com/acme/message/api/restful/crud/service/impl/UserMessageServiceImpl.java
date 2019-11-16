package com.acme.message.api.restful.crud.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acme.message.api.restful.crud.entity.UserMessage;
import com.acme.message.api.restful.crud.repository.UserMessageRepository;
import com.acme.message.api.restful.crud.service.UserMessageService;
import com.acme.message.api.restful.crud.util.converter.CollectionConverter;

@Service("userMessageService")
@Transactional(readOnly = true)
public class UserMessageServiceImpl implements UserMessageService {

	private final Logger LOG = LoggerFactory.getLogger(UserMessageServiceImpl.class);
	
	@Autowired
	private UserMessageRepository userMessageRepository;
	
	@Override
	public List<UserMessage> findAll() {
		LOG.trace("Find all UserMessage");
		
		return CollectionConverter.toList(userMessageRepository.findAll());
	}

	@Override
	public Optional<UserMessage> findByPK(Long id) {
		LOG.trace("Find UserMessage by id : {}", id);
		
		return userMessageRepository.findById(id);
	}

	@Override
	@Transactional
	public void insert(UserMessage userMessage) {
		LOG.trace("Insert UserMessage");
		
		userMessageRepository.save(userMessage);
	}

	@Override
	@Transactional
	public void update(UserMessage userMessage) {
		LOG.trace("Update UserMessage with id : {}", userMessage.getId());
		
		userMessageRepository.save(userMessage);	
	}

	@Override
	@Transactional
	public void delete(UserMessage userMessage) {
		LOG.trace("Delete UserMessage by id : {}", userMessage.getId());
		
		userMessageRepository.delete(userMessage);
	}

	public void setUserMessageRepository(UserMessageRepository userMessageRepository) {
		this.userMessageRepository = userMessageRepository;
	}

}
