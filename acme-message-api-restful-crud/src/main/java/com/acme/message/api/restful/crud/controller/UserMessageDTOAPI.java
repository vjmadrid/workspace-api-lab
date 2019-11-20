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

import com.acme.message.api.restful.crud.dto.UserMessageDTO;
import com.acme.message.api.restful.crud.entity.UserMessage;
import com.acme.message.api.restful.crud.mapper.UserMessageMapper;
import com.acme.message.api.restful.crud.service.UserMessageService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usermessagesdto")
public class UserMessageDTOAPI {
	
	public static final Logger LOG = LoggerFactory.getLogger(UserMessageDTOAPI.class);
	
	private UserMessageService userMessageService;
	
	private UserMessageMapper userMessageMapper;
	
	@Autowired
	public void setUserMessageService(UserMessageService userMessageService) {
		this.userMessageService = userMessageService;
	}

	//@Autowired
	public void setUserMessageMapper(UserMessageMapper userMessageMapper) {
		this.userMessageMapper = userMessageMapper;
	}

	@GetMapping
    public ResponseEntity<List<UserMessageDTO>> findAll() {
		LOG.info("Find All UserMessage");
		
        return ResponseEntity.ok(userMessageMapper.toUserMessageDTOList(userMessageService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserMessageDTO> findById(@PathVariable Long id) {
    	LOG.info("Fetching UserMessage with id {}", id);
    	
    	final Optional<UserMessage> userMessageFound = userMessageService.findByPK(id);
    	final UserMessage value = (userMessageFound == null || !userMessageFound.isPresent())? null:userMessageFound.get();

        return ResponseEntity.ok(userMessageMapper.toUserMessageDTO(value));
    }

    @PostMapping
    public ResponseEntity<UserMessageDTO> create(@RequestBody UserMessageDTO userMessageDTO) {
    	LOG.info("Creating UserMessageDTO : {}", userMessageDTO);
    	
    	//final Optional<UserMessage> userMessageFound = userMessageService.findByPK(userMessageDTO.getId());
    	//final UserMessage value = (userMessageFound == null || !userMessageFound.isPresent())? null:userMessageFound.get();

		userMessageService.insert(userMessageMapper.toUserMessage(userMessageDTO));
    	
        return ResponseEntity.status(HttpStatus.CREATED).body(userMessageDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserMessageDTO> update(@PathVariable Long id, @RequestBody UserMessageDTO userMessageDTO) {
    	LOG.info("Updating User with id {}", id);
    	
    	UserMessage userMessage = userMessageMapper.toUserMessage(userMessageDTO);
    	userMessage.setId(id);
    	
    	//final Optional<UserMessage> userMessageFound = userMessageService.findByPK(id);
    	//final UserMessage value = (userMessageFound == null || !userMessageFound.isPresent())? null:userMessageFound.get();
		
		userMessageService.update(userMessage);
    	
        return ResponseEntity.accepted().body(userMessageDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
    	LOG.info("Fetching & Deleting UserMessage with id {}", id);
	
    	final Optional<UserMessage> userMessageFound = userMessageService.findByPK(id);
    	final UserMessage value = (userMessageFound == null || !userMessageFound.isPresent())? null:userMessageFound.get();
		
    	userMessageService.delete(value);

        return ResponseEntity.accepted().build();
    }
	
	

}
