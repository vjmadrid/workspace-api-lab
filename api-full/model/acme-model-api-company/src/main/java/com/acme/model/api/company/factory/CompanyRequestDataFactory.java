package com.acme.model.api.company.factory;

import com.acme.model.api.company.entity.CompanyRequest;

public final class CompanyRequestDataFactory {
	
	protected CompanyRequestDataFactory() {
		throw new IllegalStateException("CompanyRequestDataFactory");
	}

	public static CompanyRequest create(String companyName) {
		final CompanyRequest response = new CompanyRequest();
		response.setCompanyName(companyName);
		return response;
	}
	
}
