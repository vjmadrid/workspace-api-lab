package com.acme.api.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acme.api.company.entity.Company;

@Repository
public interface ComapanyRepository extends JpaRepository<Company, Long> {

}
