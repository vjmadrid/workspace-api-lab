package com.acme.model.api.company.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

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
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CompanyRequest extends AbstractEntity {

	private static final long serialVersionUID = -7512113991075227729L;
	
	@NotNull
	@NotBlank
	@Length(max = 50)
	@JsonProperty(CompanyJsonFieldConstant.FIELD_COMPANY_NAME)
	private String companyName;

}
