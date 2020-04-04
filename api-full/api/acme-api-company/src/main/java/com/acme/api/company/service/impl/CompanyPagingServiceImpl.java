package com.acme.api.company.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acme.api.company.entity.Company;
import com.acme.api.company.mapper.CompanyMapper;
import com.acme.api.company.repository.CompanyPagingAndSortRepository;
import com.acme.api.company.service.CompanyPagingService;
import com.acme.architecture.core.util.AcmePageableUtil;
import com.acme.model.api.company.entity.CompanyResponse;

import lombok.Setter;

@Setter
@Service
@Transactional(readOnly = true)
public class CompanyPagingServiceImpl implements CompanyPagingService {

	@Autowired
	private CompanyPagingAndSortRepository companyPagingAndSortRepository;

	@Autowired
	private CompanyMapper companyMapper;

	@Override
	public Page<CompanyResponse> findAll(Integer pageNumber, Integer pageSize, String sortProperty, String sortOrder) {

		Pageable pageable = AcmePageableUtil.createPageRequest(pageNumber, pageSize, sortProperty, sortOrder,
				Company.class);

		return findAll(pageable);
	}

	@Override
	public Page<CompanyResponse> findAll(Pageable pageable) {

		Page<Company> companyPage = companyPagingAndSortRepository.findAll(pageable);
		List<CompanyResponse> companyResponseList = companyMapper.toCompanyResponseList(companyPage.getContent());
		
		return AcmePageableUtil.buildPage(companyResponseList, companyPage.getPageable(), companyPage.getTotalElements());
	}

}
