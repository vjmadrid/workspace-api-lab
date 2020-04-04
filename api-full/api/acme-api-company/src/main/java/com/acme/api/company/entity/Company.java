package com.acme.api.company.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.acme.api.company.constant.CompanyEntityConstant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = CompanyEntityConstant.TABLE_COMPANY)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@SequenceGenerator(name = CompanyEntityConstant.SEQUENCE_COMPANY_ID_NAME_GENERATOR, sequenceName = CompanyEntityConstant.SEQUENCE_COMPANY_ID_NAME, allocationSize = CompanyEntityConstant.SEQUENCE_COMPANY_ID_INCREMENT)
public class Company extends AuditCompany {

	private static final long serialVersionUID = -7439743000979647153L;

	@Id
	@Column(name = CompanyEntityConstant.FIELD_COMPANY_ID)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = CompanyEntityConstant.SEQUENCE_COMPANY_ID_NAME_GENERATOR)
	private Long id;

	@Column(name = CompanyEntityConstant.FIELD_COMPANY_NAME)
	private String companyName;

}
