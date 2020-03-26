package com.acme.model.api.common.response.audit.dummy;

import com.acme.model.api.common.response.audit.AuditResponse;
import com.acme.model.api.common.response.audit.dummy.constant.DummyAuditResponseConstant;

public class DummyAuditResponse {

	private DummyAuditResponse() {
		throw new IllegalStateException("DummyAuditResponse");
	}

	public static <T extends AuditResponse> void addAuditResponse(T response) {

		response.setCreatedAt(DummyAuditResponseConstant.getCreatedAt());
		response.setCreatedBy(DummyAuditResponseConstant.CREATED_BY);
		response.setModifiedAt(DummyAuditResponseConstant.getModifiedAt());
		response.setModifiedBy(DummyAuditResponseConstant.MODIFIED_BY);
	}

}
