package com.acme.message.api.restful.crud.exception;

import com.acme.message.api.restful.crud.testing.AbstractExceptionTestUtil;

public class MessageApiCrudExceptionTest extends AbstractExceptionTestUtil {

	@Override
	protected Exception getExceptionWithParameter() {
		return new MessageApiCrudException("1");
	}

}
