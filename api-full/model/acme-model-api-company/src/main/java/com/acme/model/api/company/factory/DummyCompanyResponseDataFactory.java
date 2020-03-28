package com.acme.model.api.company.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.acme.model.api.company.constant.DummyCompanyConstant;
import com.acme.model.api.company.entity.CompanyResponse;

public final class DummyCompanyResponseDataFactory {

	protected DummyCompanyResponseDataFactory() {
		throw new IllegalStateException("DummyCompanyResponseDataFactory");
	}

	public static CompanyResponse createSampleDefault() {
		CompanyResponse response = CompanyResponseDataFactory.create(DummyCompanyConstant.COMPANY_ID,
				DummyCompanyConstant.COMPANY_NAME);
		return response;
	}

	public static List<CompanyResponse> createSampleDefaultList() {
		return Arrays.asList(createSampleDefault());
	}

	public static CompanyResponse[] createSampleDefaultArray() {
		return createSampleDefaultList().stream().toArray(CompanyResponse[]::new);
	}

	public static Map<Long, CompanyResponse> createSampleMap() {
		final Map<Long, CompanyResponse> map = new HashMap<>();
		map.put(DummyCompanyConstant.COMPANY_ID_1,
				CompanyResponseDataFactory.create(DummyCompanyConstant.COMPANY_ID_1, DummyCompanyConstant.COMPANY_NAME_1));
		map.put(DummyCompanyConstant.COMPANY_ID_2,
				CompanyResponseDataFactory.create(DummyCompanyConstant.COMPANY_ID_1, DummyCompanyConstant.COMPANY_NAME_1));
		map.put(DummyCompanyConstant.COMPANY_ID_3,
				CompanyResponseDataFactory.create(DummyCompanyConstant.COMPANY_ID_1, DummyCompanyConstant.COMPANY_NAME_1));
		return map;
	}

	public static List<CompanyResponse> createSampleList() {
		final List<CompanyResponse> list = new ArrayList<>();
		list.add(CompanyResponseDataFactory.create(DummyCompanyConstant.COMPANY_ID_1, DummyCompanyConstant.COMPANY_NAME_1));
		list.add(CompanyResponseDataFactory.create(DummyCompanyConstant.COMPANY_ID_2, DummyCompanyConstant.COMPANY_NAME_2));
		list.add(CompanyResponseDataFactory.create(DummyCompanyConstant.COMPANY_ID_3, DummyCompanyConstant.COMPANY_NAME_3));
		return list;
	}

}
