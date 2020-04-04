package com.acme.model.api.common.response.audit.factory.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.acme.model.api.common.response.audit.constant.dummy.DummyAuditModelConstant;
import com.acme.model.api.common.response.audit.entity.AuditResponse;
import com.acme.model.api.common.response.audit.factory.AuditResponseDataFactory;

public final class DummyAuditResponseDataFactory {
	
	protected DummyAuditResponseDataFactory() {
		throw new IllegalStateException("DummyAuditResponseDataFactory");
	}

	public static <T extends AuditResponse> void addAuditResponse(T response) {
		response.setCreatedBy(DummyAuditModelConstant.CREATED_BY);
		response.setCreatedAt(DummyAuditModelConstant.getCreatedAt());
		response.setModifiedBy(DummyAuditModelConstant.MODIFIED_BY);
		response.setModifiedAt(DummyAuditModelConstant.getModifiedAt());
	}
	
	public static AuditResponse createSampleDefault() {
		return AuditResponseDataFactory.create(DummyAuditModelConstant.CREATED_BY);
	}
	
	public static Map<String,AuditResponse> createSampleMap() {
		final Map<String,AuditResponse> map = new HashMap<>(); 
		map.put(DummyAuditModelConstant.CREATED_BY_USER_1, AuditResponseDataFactory.create(DummyAuditModelConstant.CREATED_BY_USER_1));
		map.put(DummyAuditModelConstant.CREATED_BY_USER_2, AuditResponseDataFactory.create(DummyAuditModelConstant.CREATED_BY_USER_2));
		map.put(DummyAuditModelConstant.CREATED_BY_USER_3, AuditResponseDataFactory.create(DummyAuditModelConstant.CREATED_BY_USER_3));		
		return map;
	}
	
	public static List<AuditResponse> createSampleList() {
		final List<AuditResponse> list = new ArrayList<>();
		list.add(AuditResponseDataFactory.create(DummyAuditModelConstant.CREATED_BY_USER_1));
		list.add(AuditResponseDataFactory.create(DummyAuditModelConstant.CREATED_BY_USER_2));
		list.add(AuditResponseDataFactory.create(DummyAuditModelConstant.CREATED_BY_USER_3));
		return list;
	}

}
