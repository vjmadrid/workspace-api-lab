package com.acme.message.api.restful.crud.validator;

import com.acme.message.api.restful.crud.entity.UserMessage;

public enum UserMessageValidator {

	INSTANCE;

	public boolean isNull(UserMessage userMessage) {
		return (userMessage == null);
	}

	public boolean isNotNull(UserMessage userMessage) {
		return (userMessage != null);
	}

	public boolean isValid(UserMessage userMessage) {
		return (isNotNull(userMessage) && userMessage.getId() != null);
	}
	
	public boolean isValidVip(UserMessage userMessage) {
		return (isValid(userMessage) && userMessage.isVip());
	}
	
	public boolean isDeletedLogical(UserMessage userMessage) {
		return (isValid(userMessage) && (userMessage.getDeletedDate()!=null));
	}
}
