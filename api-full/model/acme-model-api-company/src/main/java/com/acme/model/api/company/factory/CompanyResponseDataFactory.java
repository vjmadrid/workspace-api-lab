package com.acme.model.api.company.factory;

import com.acme.model.api.company.entity.CompanyResponse;

public final class CompanyResponseDataFactory {
	
	protected CompanyResponseDataFactory() {
		throw new IllegalStateException("CompanyResponseDataFactory");
	}

	public static CompanyResponse create(Long id, String companyName) {
		final CompanyResponse response = new CompanyResponse();
		response.setId(id);
		response.setCompanyName(companyName);
		return response;
	}
	
}
