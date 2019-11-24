package com.acme.message.api.restful.crud.util.converter;

import com.fasterxml.jackson.databind.ObjectMapper;

public final class StringConverter {

	private StringConverter() {
	}
	
	public static String toJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
