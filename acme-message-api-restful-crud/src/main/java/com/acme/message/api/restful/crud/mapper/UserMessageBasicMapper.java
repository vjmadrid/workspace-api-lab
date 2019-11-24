package com.acme.message.api.restful.crud.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.acme.message.api.restful.crud.dto.UserMessageDTO;
import com.acme.message.api.restful.crud.entity.UserMessage;

//@Mapper
public interface UserMessageBasicMapper {
	
	UserMessageBasicMapper INSTANCE = Mappers.getMapper(UserMessageBasicMapper.class);

	UserMessageDTO toUserMessageDTO(UserMessage userMessage);

}
