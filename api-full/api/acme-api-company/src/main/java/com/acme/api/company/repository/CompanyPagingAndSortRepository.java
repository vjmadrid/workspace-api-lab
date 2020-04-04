package com.acme.api.company.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.acme.api.company.entity.Company;

@Repository
public interface CompanyPagingAndSortRepository extends PagingAndSortingRepository<Company, Long> {
	
}
