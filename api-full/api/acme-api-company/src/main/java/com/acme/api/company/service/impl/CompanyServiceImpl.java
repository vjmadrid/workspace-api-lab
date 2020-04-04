package com.acme.api.company.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acme.api.company.entity.Company;
import com.acme.api.company.mapper.CompanyMapper;
import com.acme.api.company.repository.ComapanyRepository;
import com.acme.api.company.service.CompanyService;
import com.acme.architecture.common.util.converter.CollectionConverter;
import com.acme.model.api.company.entity.CompanyRequest;
import com.acme.model.api.company.entity.CompanyResponse;

import lombok.Setter;

@Setter
@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private ComapanyRepository companyRepository;

	@Autowired
	private CompanyMapper companyMapper;

	@Override
	public List<CompanyResponse> findAll() {

		List<Company> companyList = CollectionConverter.toList(companyRepository.findAll());
		return companyMapper.toCompanyResponseList(companyList);
	}

	@Override
	public Optional<CompanyResponse> findByPK(Long id) {

		Optional<Company> company = companyRepository.findById(id);
		return (company.isPresent()) ? Optional.of(companyMapper.toCompanyResponse(company.get())) : Optional.empty();
	}

	@Override
	public List<CompanyResponse> findByPKList(List<Long> ids) {

		List<Company> companyList = CollectionConverter.toList(companyRepository.findAllById(ids));
		return companyMapper.toCompanyResponseList(companyList);
	}

	@Override
	public CompanyResponse create(CompanyRequest companyRequest, String userId) {

		System.out.println("companyRequest ::"+companyRequest);
		
		Company company = companyMapper.toCompany(companyRequest);
		
		System.out.println("company ::"+company.getCompanyName());
		
		company.setCreatedBy(userId);
		company.setCreatedAt(new Date());
		company = companyRepository.save(company);
		return companyMapper.toCompanyResponse(company);
	}

	@Override
	public Optional<CompanyResponse> update(Long id, CompanyRequest companyRequest, String userId) {

		Optional<Company> optionalCompany = companyRepository.findById(id);

		if (!optionalCompany.isPresent()) {
			return Optional.empty();
		}

		Company company = optionalCompany.get();
		company.setId(id);
		company.setCompanyName(companyRequest.getCompanyName());
		company.setModifiedAt(new Date());
		company.setModifiedBy(userId);
		company = companyRepository.save(company);

		return Optional.of(companyMapper.toCompanyResponse(company));
	}

	@Override
	public boolean existByPK(Long id) {
		return companyRepository.existsById(id);
	}

}
