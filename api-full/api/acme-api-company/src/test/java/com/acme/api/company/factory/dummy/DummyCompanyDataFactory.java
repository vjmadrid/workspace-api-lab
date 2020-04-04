package com.acme.api.company.factory.dummy;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.acme.api.company.entity.Company;
import com.acme.model.api.common.response.audit.constant.dummy.DummyAuditModelConstant;
import com.acme.model.api.company.constant.dummy.DummyCompanyModelConstant;

public final class DummyCompanyDataFactory {
	
	protected DummyCompanyDataFactory() {
		throw new IllegalStateException("DummyCompanyDataFactory");
	}

	public static Company createSampleDefault() {
		Company company = new Company(DummyCompanyModelConstant.COMPANY_ID, DummyCompanyModelConstant.COMPANY_NAME);
		company.setCreatedBy(DummyAuditModelConstant.CREATED_BY);
		company.setCreatedAt(DummyAuditModelConstant.getCreatedAt());
		return company;
	}

	public static Company createSampleUpdated() {
		Company company = createSampleDefault();
		company.setModifiedAt(DummyAuditModelConstant.getCreatedAt());
		company.setModifiedBy(DummyAuditModelConstant.MODIFIED_BY);
		return company;
	}

	public static List<Company> createSampleDefaultList() {
		return Arrays.asList(createSampleDefault());
	}

	public static Page<Company> createSampleDefaultPage() {
		List<Company> list = createSampleDefaultList();
		return new PageImpl<Company>(list, PageRequest.of(0, 1, Sort.unsorted()), list.size());
	}
}
