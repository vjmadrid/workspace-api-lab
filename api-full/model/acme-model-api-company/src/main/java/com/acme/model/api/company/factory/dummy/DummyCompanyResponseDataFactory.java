package com.acme.model.api.company.factory.dummy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.acme.model.api.company.constant.dummy.DummyCompanyModelConstant;
import com.acme.model.api.company.entity.CompanyResponse;
import com.acme.model.api.company.factory.CompanyResponseDataFactory;

public final class DummyCompanyResponseDataFactory {

	protected DummyCompanyResponseDataFactory() {
		throw new IllegalStateException("DummyCompanyResponseDataFactory");
	}

	public static CompanyResponse createSampleDefault() {
		CompanyResponse response = CompanyResponseDataFactory.create(DummyCompanyModelConstant.COMPANY_ID,
				DummyCompanyModelConstant.COMPANY_NAME);
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
		map.put(DummyCompanyModelConstant.COMPANY_ID_1,
				CompanyResponseDataFactory.create(DummyCompanyModelConstant.COMPANY_ID_1, DummyCompanyModelConstant.COMPANY_NAME_1));
		map.put(DummyCompanyModelConstant.COMPANY_ID_2,
				CompanyResponseDataFactory.create(DummyCompanyModelConstant.COMPANY_ID_1, DummyCompanyModelConstant.COMPANY_NAME_1));
		map.put(DummyCompanyModelConstant.COMPANY_ID_3,
				CompanyResponseDataFactory.create(DummyCompanyModelConstant.COMPANY_ID_1, DummyCompanyModelConstant.COMPANY_NAME_1));
		return map;
	}

	public static List<CompanyResponse> createSampleList() {
		final List<CompanyResponse> list = new ArrayList<>();
		list.add(CompanyResponseDataFactory.create(DummyCompanyModelConstant.COMPANY_ID_1, DummyCompanyModelConstant.COMPANY_NAME_1));
		list.add(CompanyResponseDataFactory.create(DummyCompanyModelConstant.COMPANY_ID_2, DummyCompanyModelConstant.COMPANY_NAME_2));
		list.add(CompanyResponseDataFactory.create(DummyCompanyModelConstant.COMPANY_ID_3, DummyCompanyModelConstant.COMPANY_NAME_3));
		return list;
	}

}
