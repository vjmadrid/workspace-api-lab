package com.acme.message.api.restful.crud.entity;

public class CustomErrorTypeMessage {

	private String errorMessage;

    public CustomErrorTypeMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
	
	
}
