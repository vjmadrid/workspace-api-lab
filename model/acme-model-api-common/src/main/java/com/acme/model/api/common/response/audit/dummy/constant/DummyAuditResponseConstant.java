package com.acme.model.api.common.response.audit.dummy.constant;

import java.util.Date;

import com.acme.model.api.common.dummy.DummyDateTime;

public final class DummyAuditResponseConstant {

	private DummyAuditResponseConstant() {

	}

	public static final String CREATED_BY = "user";
	
	public static final String MODIFIED_BY = "user";

	public static final Date getCreatedAt() {
		return DummyDateTime.getDate();
	}

	public static final Date getModifiedAt() {
		return DummyDateTime.getFutureDate();
	}

}
