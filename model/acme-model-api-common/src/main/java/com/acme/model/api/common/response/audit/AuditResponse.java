package com.acme.model.api.common.response.audit;

import java.util.Date;

import com.acme.architecture.common.entity.AbstractEntity;
import com.acme.model.api.common.response.audit.constant.AuditJsonFieldConstant;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class AuditResponse extends AbstractEntity {

	private static final long serialVersionUID = -5951445040684936486L;

	@JsonProperty(AuditJsonFieldConstant.FIELD_CREATED_BY)
	private String createdBy;

	@JsonFormat(pattern = AuditJsonFieldConstant.DATE_PATTERN)
	@JsonProperty(AuditJsonFieldConstant.FIELD_CREATED_AT)
	private Date createdAt;

	@JsonIgnore
	@JsonProperty(AuditJsonFieldConstant.FIELD_MODIFIED_BY)
	private String modifiedBy;

	@JsonIgnore
	@JsonFormat(pattern = AuditJsonFieldConstant.DATE_PATTERN)
	@JsonProperty(AuditJsonFieldConstant.FIELD_MODIFIED_AT)
	private Date modifiedAt;
}
