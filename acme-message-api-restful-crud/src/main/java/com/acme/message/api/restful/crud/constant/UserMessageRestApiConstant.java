package com.acme.message.api.restful.crud.constant;

public final class UserMessageRestApiConstant {

	private UserMessageRestApiConstant() {
	}
	
	public static final String MAPPING = "/api/v1/usermessages";	
	public static final String MAPPING_PK = "/{id}";
	
	public static final String MESSAGE_TEMPLATE = "usermessage.validation.error.XXX";
	public static final String MESSAGE_NOT_FOUND = "usermessage.validation.error.NOT_FOUND";
	public static final String MESSAGE_EXIST = "usermessage.validation.error.EXIST";
	
}
