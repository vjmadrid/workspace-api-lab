package com.acme.model.api.company.entity;

import com.acme.architecture.common.entity.AbstractEntity;
import com.acme.model.api.company.constant.CompanyJsonFieldConstant;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CompanyResponse extends AbstractEntity {

	private static final long serialVersionUID = -5997995476333537667L;

	@JsonProperty(CompanyJsonFieldConstant.FIELD_COMPANY_ID)
	private Long id;

	@JsonProperty(CompanyJsonFieldConstant.FIELD_COMPANY_NAME)
	private String companyName;

}
