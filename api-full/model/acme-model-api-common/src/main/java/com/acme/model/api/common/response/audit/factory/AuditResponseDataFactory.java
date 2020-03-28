package com.acme.model.api.common.response.audit.factory;

import java.util.Date;

import com.acme.model.api.common.response.audit.entity.AuditResponse;

public final class AuditResponseDataFactory {
	
	protected AuditResponseDataFactory() {
		throw new IllegalStateException("AuditResponseDataFactory");
	}

	public static AuditResponse create(String createdBy) {
		final AuditResponse response = new AuditResponse();
		response.setCreatedBy(createdBy);
		response.setCreatedAt(new Date());
		response.setModifiedBy(null);
		response.setModifiedAt(null);
		return response;
	}
	
	public static AuditResponse createUpdated(String createdBy, String modifiedBy) {
		final AuditResponse response = create(createdBy);
		response.setModifiedBy(modifiedBy);
		response.setModifiedAt(new Date());
		return response;
	}
	
}
