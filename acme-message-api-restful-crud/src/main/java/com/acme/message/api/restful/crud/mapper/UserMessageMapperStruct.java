package com.acme.message.api.restful.crud.mapper;

import java.util.List;
import java.util.stream.Stream;

import org.mapstruct.Mapper;

import com.acme.message.api.restful.crud.dto.UserMessageDTO;
import com.acme.message.api.restful.crud.entity.UserMessage;

//@Mapper(componentModel = "spring")
public interface UserMessageMapperStruct {


	UserMessageDTO toUserMessageDTO(UserMessage userMessage);

    List<UserMessageDTO> toUserMessageDTOList(Stream<UserMessage> userMessageList);

	UserMessage toUserMessage(UserMessageDTO userMessageDTO);

}
