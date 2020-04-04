package com.acme.api.company.mapper;

import java.util.List;

import com.acme.api.company.entity.Company;
import com.acme.model.api.company.entity.CompanyRequest;
import com.acme.model.api.company.entity.CompanyResponse;

public interface CompanyMapper {

	Company toCompany(CompanyRequest companyDTO);

	List<CompanyResponse> toCompanyResponseList(List<Company> companyList);

	CompanyResponse toCompanyResponse(Company company);

}
