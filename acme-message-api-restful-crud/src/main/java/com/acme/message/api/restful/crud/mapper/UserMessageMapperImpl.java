package com.acme.message.api.restful.crud.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acme.message.api.restful.crud.dto.UserMessageDTO;
import com.acme.message.api.restful.crud.entity.UserMessage;

//@Component
public class UserMessageMapperImpl implements UserMessageMapper {

	@Autowired
	private UserMessageMapperStruct mapperStruct;

	@Override
	public UserMessageDTO toUserMessageDTO(UserMessage userMessage) {
		return mapperStruct.toUserMessageDTO(userMessage);
	}

	@Override
	public List<UserMessageDTO> toUserMessageDTOList(List<UserMessage> userMessageList) {
		List<UserMessageDTO> messageDTOList = new ArrayList<>();
		userMessageList.forEach(u -> messageDTOList.add(mapperStruct.toUserMessageDTO(u)));
		return messageDTOList;
	}

	@Override
	public UserMessage toUserMessage(UserMessageDTO userMessageDTO) {
		return mapperStruct.toUserMessage(userMessageDTO);
	}

}
