package com.acme.api.company.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acme.api.company.entity.Company;
import com.acme.api.company.mapper.struct.CompanyMapperStruct;
import com.acme.model.api.company.entity.CompanyRequest;
import com.acme.model.api.company.entity.CompanyResponse;

import lombok.Setter;

@Setter
@Component
public class CompanyMapperImpl implements CompanyMapper {

	@Autowired
	private CompanyMapperStruct mapperStruct;

	@Override
	public Company toCompany(CompanyRequest companyDto) {
		return mapperStruct.toCompany(companyDto);
	}

	@Override
	public List<CompanyResponse> toCompanyResponseList(List<Company> companyList) {
		return mapperStruct.toCompanyResponseList(companyList.stream());
	}

	@Override
	public CompanyResponse toCompanyResponse(Company company) {
		return mapperStruct.toCompanyResponse(company);
	}

}
