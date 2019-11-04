package com.acme.message.api.restful.crud.factory;

import java.util.Date;

import com.acme.message.api.restful.crud.entity.UserMessage;

public final class UserMessageDataFactory {

	public static UserMessage create(String description, boolean vip) {
		final UserMessage userMessage = new UserMessage();
		userMessage.setDescription(description);
		userMessage.setVip(vip);
		userMessage.setCreationDate(new Date());
		userMessage.setDeletedDate(null);
		return userMessage;
	}
	
	public static UserMessage create(long id, String description, boolean vip) {
		final UserMessage userMessage = create(description,vip);
		userMessage.setId(id);
		return userMessage;
	}
	
}
