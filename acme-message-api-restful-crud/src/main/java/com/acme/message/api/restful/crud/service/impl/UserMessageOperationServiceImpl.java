package com.acme.message.api.restful.crud.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acme.message.api.restful.crud.entity.UserMessage;
import com.acme.message.api.restful.crud.exception.MessageApiCrudException;
import com.acme.message.api.restful.crud.exception.enumerate.UserMessageTypeExceptionEnum;
import com.acme.message.api.restful.crud.repository.UserMessageRepository;
import com.acme.message.api.restful.crud.service.UserMessageOperationService;
import com.acme.message.api.restful.crud.validator.UserMessageValidator;

@Service("userMessageOperationService")
@Transactional
public class UserMessageOperationServiceImpl implements UserMessageOperationService {
	
	private final Logger LOG = LoggerFactory.getLogger(UserMessageOperationServiceImpl.class);
	
	@Autowired
	private UserMessageRepository userMessageRepository;

	@Override
	public List<UserMessage> findAllVips() {
		LOG.trace("Find All Vips");
		
		Iterable<UserMessage> iterable  = userMessageRepository.findAll();

		List<UserMessage> result = StreamSupport.stream(iterable.spliterator(), false)
			      .filter(userMessage -> (userMessage.getDeletedDate()!=null))
			      .collect(Collectors.toList());
		
		return result;
	}
	
	private void generateNotFoundException(UserMessage userMessage) throws MessageApiCrudException {
		
		if (!UserMessageValidator.INSTANCE.isValid(userMessage)) {
			throw new MessageApiCrudException(UserMessageTypeExceptionEnum.NOT_FOUND.name());
		}
	}

	@Override
	public void deleteLogical(Long id) throws MessageApiCrudException {
		LOG.trace("Delete Logical UserMessafe with id : {}", id);
		
		final Optional<UserMessage> userMessage = userMessageRepository.findById(id);
		
		UserMessage value = (userMessage == null || !userMessage.isPresent())? null:userMessage.get();
		
		generateNotFoundException(value);
	
		if (UserMessageValidator.INSTANCE.isDeletedLogical(value)){
			throw new MessageApiCrudException(UserMessageTypeExceptionEnum.IS_DELETED_LOGICAL.name());
		}
		
		value.setDeletedDate(new Date());
		userMessageRepository.save(value);
		
		LOG.trace("UserMessage deleted logical with id : {}", id);
	}
	
	public void setUserMessageRepository(UserMessageRepository userMessageRepository) {
		this.userMessageRepository = userMessageRepository;
	}

}
