package com.acme.message.api.restful.crud.factory;

import com.acme.message.api.restful.crud.dto.UserMessageDTO;

public final class UserMessageDTODataFactory {

	public static UserMessageDTO create(long id, String description, boolean vip) {
		final UserMessageDTO userMessageDTO = new UserMessageDTO();
		userMessageDTO.setId(id);
		userMessageDTO.setDescription(description);
		userMessageDTO.setVip(vip);
		return userMessageDTO;
	}
	
}
