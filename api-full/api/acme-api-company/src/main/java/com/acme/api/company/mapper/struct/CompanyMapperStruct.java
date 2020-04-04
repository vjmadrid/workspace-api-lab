package com.acme.api.company.mapper.struct;

import java.util.List;
import java.util.stream.Stream;

import org.mapstruct.Mapper;

import com.acme.api.company.entity.Company;
import com.acme.model.api.company.entity.CompanyRequest;
import com.acme.model.api.company.entity.CompanyResponse;

@Mapper(componentModel = "spring")
public interface CompanyMapperStruct {

	Company toCompany(CompanyRequest companyDto);

	List<CompanyResponse> toCompanyResponseList(Stream<Company> companyList);

	CompanyResponse toCompanyResponse(Company company);

}
