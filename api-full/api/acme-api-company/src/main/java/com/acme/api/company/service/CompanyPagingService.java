package com.acme.api.company.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.acme.model.api.company.entity.CompanyResponse;

public interface CompanyPagingService {

	Page<CompanyResponse> findAll(Pageable pageable);

	Page<CompanyResponse> findAll(Integer pageNumber, Integer pageSize, String sortProperty, String sortOrder);

}
