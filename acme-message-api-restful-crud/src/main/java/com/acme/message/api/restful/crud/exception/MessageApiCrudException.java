package com.acme.message.api.restful.crud.exception;

public class MessageApiCrudException extends Exception {

	private static final long serialVersionUID = -7253139154822971989L;

	public MessageApiCrudException(String header) {
		this(header, "");
	}
	
	public MessageApiCrudException(String header, String message) {
		super(new StringBuilder(header).append(message).toString());
	}

}
