package com.acme.message.api.restful.crud.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acme.message.api.restful.crud.entity.UserMessage;
import com.acme.message.api.restful.crud.service.UserMessageService;

@RestController
@RequestMapping("/usermessages")
public class UserMessageAPI {
	
	public static final Logger LOG = LoggerFactory.getLogger(UserMessageAPI.class);
	
	private UserMessageService userMessageService;

	@Autowired
	public void setUserMessageService(UserMessageService userMessageService) {
		this.userMessageService = userMessageService;
	}
	
	@GetMapping
    public ResponseEntity<List<UserMessage>> findAll() {
		LOG.info("Find All UserMessage");
		
        return ResponseEntity.ok(userMessageService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserMessage> findById(@PathVariable Long id) {
    	LOG.info("Fetching UserMessage with id {}", id);
    	
    	final Optional<UserMessage> userMessageFound = userMessageService.findByPK(id);

        return ResponseEntity.ok(userMessageService.findByPK(id).get());
    }

    @PostMapping
    public ResponseEntity<UserMessage> create(UserMessage userMessage) {
    	LOG.info("Creating UserMessage : {}", userMessage);
    	
    	final Optional<UserMessage> userMessageFound = userMessageService.findByPK(userMessage.getId());
		
		UserMessage value = userMessageFound.get();
		
		userMessageService.insert(value);
    	
        return ResponseEntity.status(HttpStatus.CREATED).body(value);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserMessage> update(@PathVariable Long id, @RequestBody UserMessage userMessage) {
    	LOG.info("Updating User with id {}", id);
    	
    	final Optional<UserMessage> userMessageFound = userMessageService.findByPK(id);
		
		UserMessage value = userMessageFound.get();
		
		userMessageService.update(value);
    	
        return ResponseEntity.accepted().body(value);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
    	LOG.info("Fetching & Deleting UserMessage with id {}", id);
    	
    	final Optional<UserMessage> userMessageFound = userMessageService.findByPK(id);
    	
    	userMessageService.delete(userMessageFound.get());

        return ResponseEntity.accepted().build();
    }
	
	

}
