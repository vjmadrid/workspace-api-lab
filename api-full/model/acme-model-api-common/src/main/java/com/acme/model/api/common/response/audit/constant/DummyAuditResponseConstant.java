package com.acme.model.api.common.response.audit.constant;

import java.util.Date;

import com.acme.model.api.common.factory.dummy.DummyDateTimeDataFactory;

public final class DummyAuditResponseConstant {

	private DummyAuditResponseConstant() {
	}

	public static final String CREATED_BY = "user";
	
	public static final String MODIFIED_BY = "user";
	
	
	
	public static final Integer TEST_NUM_USERS = 3;
	
	public static final String CREATED_BY_USER_1 = "user 1";
	public static final String CREATED_BY_USER_2 = "user 2";
	public static final String CREATED_BY_USER_3 = "user 3";
	
	public static final Date getCreatedAt() {
		return DummyDateTimeDataFactory.getDate();
	}

	public static final Date getModifiedAt() {
		return DummyDateTimeDataFactory.getFutureDate();
	}

}
