package com.acme.model.api.company.factory.dummy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.acme.model.api.company.constant.dummy.DummyCompanyModelConstant;
import com.acme.model.api.company.entity.CompanyRequest;
import com.acme.model.api.company.factory.CompanyRequestDataFactory;

public final class DummyCompanyRequestDataFactory {

	protected DummyCompanyRequestDataFactory() {
		throw new IllegalStateException("DummyCompanyRequestDataFactory");
	}

	public static CompanyRequest createSampleDefault() {
		return new CompanyRequest(DummyCompanyModelConstant.COMPANY_NAME);
	}

	public static List<CompanyRequest> createSampleDefaultList() {
		return Arrays.asList(createSampleDefault());
	}

	public static CompanyRequest[] createSampleDefaultArray() {
		return createSampleDefaultList().stream().toArray(CompanyRequest[]::new);
	}

	public static Map<Long, CompanyRequest> createSampleMap() {
		final Map<Long, CompanyRequest> map = new HashMap<>();
		map.put(DummyCompanyModelConstant.COMPANY_ID_1,
				CompanyRequestDataFactory.create(DummyCompanyModelConstant.COMPANY_NAME_1));
		map.put(DummyCompanyModelConstant.COMPANY_ID_2,
				CompanyRequestDataFactory.create(DummyCompanyModelConstant.COMPANY_NAME_1));
		map.put(DummyCompanyModelConstant.COMPANY_ID_3,
				CompanyRequestDataFactory.create(DummyCompanyModelConstant.COMPANY_NAME_1));
		return map;
	}

	public static List<CompanyRequest> createSampleList() {
		final List<CompanyRequest> list = new ArrayList<>();
		list.add(CompanyRequestDataFactory.create(DummyCompanyModelConstant.COMPANY_NAME_1));
		list.add(CompanyRequestDataFactory.create(DummyCompanyModelConstant.COMPANY_NAME_2));
		list.add(CompanyRequestDataFactory.create(DummyCompanyModelConstant.COMPANY_NAME_3));
		return list;
	}

}
