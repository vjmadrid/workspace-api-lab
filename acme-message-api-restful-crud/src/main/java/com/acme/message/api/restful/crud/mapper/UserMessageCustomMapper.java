package com.acme.message.api.restful.crud.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.acme.message.api.restful.crud.dto.UserMessageDTO;
import com.acme.message.api.restful.crud.entity.UserMessage;

//@Mapper(componentModel = "spring")
public interface UserMessageCustomMapper {

	UserMessageDTO toUserMessageDTO(UserMessage userMessage);

	List<UserMessageDTO> toUserMessageDTOList(List<UserMessage> userMessageList);

	UserMessage toUserMessage(UserMessageDTO userMessageDTO);

}
