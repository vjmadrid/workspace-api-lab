package com.acme.api.company.service;

import java.util.List;
import java.util.Optional;

import com.acme.model.api.company.entity.CompanyRequest;
import com.acme.model.api.company.entity.CompanyResponse;

public interface CompanyService {

	List<CompanyResponse> findAll();

	Optional<CompanyResponse> findByPK(Long id);
	
	List<CompanyResponse> findByPKList(List<Long> ids);

	CompanyResponse create(CompanyRequest companyRequest, String userId);

	Optional<CompanyResponse> update(Long id, CompanyRequest companyRequest, String userId);

	boolean existByPK(Long id);

}
