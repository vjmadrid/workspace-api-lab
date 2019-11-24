package com.acme.message.api.restful.crud.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acme.message.api.restful.crud.dto.UserMessageDTO;
import com.acme.message.api.restful.crud.entity.UserMessage;

//@Component("userMessageCustomMapper")
public class UserMessageAdapterCustomMapperImpl implements UserMessageCustomMapper {

	@Autowired
	private UserMessageCustomMapper userMessageCustomMapper;

	@Override
	public UserMessageDTO toUserMessageDTO(UserMessage userMessage) {
		return userMessageCustomMapper.toUserMessageDTO(userMessage);
	}

	@Override
	public List<UserMessageDTO> toUserMessageDTOList(List<UserMessage> userMessageList) {
		List<UserMessageDTO> messageDTOList = new ArrayList<>();
		userMessageList.forEach(u -> messageDTOList.add(userMessageCustomMapper.toUserMessageDTO(u)));
		return messageDTOList;
	}

	@Override
	public UserMessage toUserMessage(UserMessageDTO userMessageDTO) {
		return userMessageCustomMapper.toUserMessage(userMessageDTO);
	}

}
