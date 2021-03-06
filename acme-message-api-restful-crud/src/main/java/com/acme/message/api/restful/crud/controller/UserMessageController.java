package com.acme.message.api.restful.crud.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.util.UriComponentsBuilder;

import com.acme.message.api.restful.crud.constant.UserMessageRestApiConstant;
import com.acme.message.api.restful.crud.entity.CustomErrorTypeMessage;
import com.acme.message.api.restful.crud.entity.UserMessage;
import com.acme.message.api.restful.crud.service.UserMessageService;
import com.acme.message.api.restful.crud.validator.UserMessageValidator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(description = "Endpoints for CRUD of UserMessages",
tags = {"usermessage"})
@RestController
@RequestMapping(UserMessageRestApiConstant.MAPPING)
@Transactional
@CrossOrigin(origins = "*")
public class UserMessageController {

	public static final Logger LOG = LoggerFactory.getLogger(UserMessageController.class);

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private UserMessageService userMessageService;
	
	@ApiOperation(value = "Find All UserMessages", notes = "Returns a list", tags = { "usermessage" })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful operation", response=List.class )  }
    )	    
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserMessage>> findAll() {
		LOG.info("Find All UserMessage");
		final List<UserMessage> userMessageList = userMessageService.findAll();
			
		if (userMessageList == null || userMessageList.isEmpty()) {
			return new ResponseEntity<List<UserMessage>>(HttpStatus.NOT_FOUND);
			// Option 1 : return new ResponseEntity<List<UserMessage>>(HttpStatus.NOT_FOUND);
			// Option 2 : return HttpStatus.NO_CONTENT -> return new ResponseEntity<List<UserMessage>>(HttpStatus.NO_CONTENT)
			// Option 3 : return ResponseEntity.notFound().build();
		}

		return new ResponseEntity<List<UserMessage>>(userMessageList, HttpStatus.OK);
	}

	private String generateErrorMessage(String type, Object[] pks, HttpServletRequest request) {
		return messageSource.getMessage(type, pks, RequestContextUtils.getLocale(request));
	}

	@ApiOperation(value = "Find UserMessage by ID", notes = "Returns a single UserMessage", tags = { "usermessage" })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "successful operation", response=UserMessage.class),
        @ApiResponse(code = 404, message = "UserMessage not found") })
	@RequestMapping(value = UserMessageRestApiConstant.MAPPING_PK, method = RequestMethod.GET)
	public ResponseEntity<?> findByPk(
			@ApiParam("Id of the UserMessage to be obtained. Cannot be empty.")
			@PathVariable("id") long id, HttpServletRequest request) {
		LOG.info("Fetching UserMessage with id {}", id);
		
		final Optional<UserMessage> userMessageFound = userMessageService.findByPK(id);
		
		if (userMessageFound == null || !userMessageFound.isPresent())
			return ResponseEntity.notFound().build();
		
		UserMessage value = userMessageFound.get();

		if (!UserMessageValidator.INSTANCE.isValid(value)) {
			final String errorMessage = generateErrorMessage(UserMessageRestApiConstant.MESSAGE_NOT_FOUND,
					new Object[] { id }, request);
			LOG.error(errorMessage);
			return new ResponseEntity<Object>(new CustomErrorTypeMessage(errorMessage), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserMessage>(value, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insert(@Valid @RequestBody UserMessage userMessage, UriComponentsBuilder ucBuilder,
			HttpServletRequest request) {
		LOG.info("Creating UserMessage : {}", userMessage);
		
		userMessageService.insert(userMessage);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path(UserMessageRestApiConstant.MAPPING+UserMessageRestApiConstant.MAPPING_PK).buildAndExpand(userMessage.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = UserMessageRestApiConstant.MAPPING_PK, method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody UserMessage userMessage,
			HttpServletRequest request) {
		LOG.info("Updating User with id {}", id);
		final Optional<UserMessage> userMessageFound = userMessageService.findByPK(id);
		
		UserMessage value = (userMessageFound == null || !userMessageFound.isPresent())? null:userMessageFound.get();

		if (!UserMessageValidator.INSTANCE.isValid(value)) {
			final String errorMessage = generateErrorMessage(UserMessageRestApiConstant.MESSAGE_NOT_FOUND,
					new Object[] { id }, request); 
			LOG.error(errorMessage);
			return new ResponseEntity<Object>(new CustomErrorTypeMessage(errorMessage), HttpStatus.NOT_FOUND);
		}

		value.setDescription(userMessage.getDescription());
		value.setVip(userMessage.isVip());
		value.setCreationDate(userMessage.getCreationDate());
		value.setDeletedDate(userMessage.getDeletedDate());
		
		userMessageService.update(value);
		return new ResponseEntity<UserMessage>(value, HttpStatus.OK);
	}

	@RequestMapping(value = UserMessageRestApiConstant.MAPPING_PK, method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") long id, HttpServletRequest request) {
		LOG.info("Fetching & Deleting UserMessage with id {}", id);
		
		final Optional<UserMessage> userMessageFound = userMessageService.findByPK(id);
		
		UserMessage value = (userMessageFound == null || !userMessageFound.isPresent())? null:userMessageFound.get();
		
		if (!UserMessageValidator.INSTANCE.isValid(value)) {
			final String errorMessage = generateErrorMessage(UserMessageRestApiConstant.MESSAGE_NOT_FOUND,
					new Object[] { id }, request); 
			LOG.error(errorMessage);
			return new ResponseEntity<Object>(new CustomErrorTypeMessage(errorMessage), HttpStatus.NOT_FOUND);
		}

		userMessageService.delete(value);
		
		return new ResponseEntity<UserMessage>(HttpStatus.OK);
	}

	public void setUserMessageService(UserMessageService userMessageService) {
		this.userMessageService = userMessageService;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

}