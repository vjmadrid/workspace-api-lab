package com.acme.api.company.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.acme.architecture.common.constant.CommonEntityConstant;
import com.acme.architecture.common.entity.AbstractEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class AuditCompany extends AbstractEntity {

	private static final long serialVersionUID = -7204167248887868057L;

	@Column(name = CommonEntityConstant.FIELD_CREATED_BY)
	private String createdBy;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = CommonEntityConstant.FIELD_CREATED_AT)
	private Date createdAt;

	@Column(name = CommonEntityConstant.FIELD_MODIFIED_AT)
	private Date modifiedAt;

	@Column(name = CommonEntityConstant.FIELD_MODIFIED_BY)
	private String modifiedBy;

}
