package com.acme.model.api.common.response.audit.constant;

public final class AuditJsonFieldConstant {

	private AuditJsonFieldConstant() {

	}

	/** COMMON FIELDS **/
	public static final String FIELD_CREATED_BY = "createdBy";
	public static final String FIELD_CREATED_AT = "createdAt";
	public static final String FIELD_MODIFIED_BY = "modifiedBy";
	public static final String FIELD_MODIFIED_AT = "modifiedAt";

	/** COMMON PATTERNS **/
	public static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";

}
