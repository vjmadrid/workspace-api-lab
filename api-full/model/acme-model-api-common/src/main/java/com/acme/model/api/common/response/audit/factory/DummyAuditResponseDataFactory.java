package com.acme.model.api.common.response.audit.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.acme.model.api.common.response.audit.constant.DummyAuditResponseConstant;
import com.acme.model.api.common.response.audit.entity.AuditResponse;

public final class DummyAuditResponseDataFactory {
	
	protected DummyAuditResponseDataFactory() {
		throw new IllegalStateException("DummyAuditResponseDataFactory");
	}

	public static <T extends AuditResponse> void addAuditResponse(T response) {
		response.setCreatedBy(DummyAuditResponseConstant.CREATED_BY);
		response.setCreatedAt(DummyAuditResponseConstant.getCreatedAt());
		response.setModifiedBy(DummyAuditResponseConstant.MODIFIED_BY);
		response.setModifiedAt(DummyAuditResponseConstant.getModifiedAt());
	}
	
	public static AuditResponse createSampleDefault() {
		return AuditResponseDataFactory.create(DummyAuditResponseConstant.CREATED_BY);
	}
	
	public static Map<String,AuditResponse> createSampleMap() {
		final Map<String,AuditResponse> map = new HashMap<>(); 
		map.put(DummyAuditResponseConstant.CREATED_BY_USER_1, AuditResponseDataFactory.create(DummyAuditResponseConstant.CREATED_BY_USER_1));
		map.put(DummyAuditResponseConstant.CREATED_BY_USER_2, AuditResponseDataFactory.create(DummyAuditResponseConstant.CREATED_BY_USER_2));
		map.put(DummyAuditResponseConstant.CREATED_BY_USER_3, AuditResponseDataFactory.create(DummyAuditResponseConstant.CREATED_BY_USER_3));		
		return map;
	}
	
	public static List<AuditResponse> createSampleList() {
		final List<AuditResponse> list = new ArrayList<>();
		list.add(AuditResponseDataFactory.create(DummyAuditResponseConstant.CREATED_BY_USER_1));
		list.add(AuditResponseDataFactory.create(DummyAuditResponseConstant.CREATED_BY_USER_2));
		list.add(AuditResponseDataFactory.create(DummyAuditResponseConstant.CREATED_BY_USER_3));
		return list;
	}

}
