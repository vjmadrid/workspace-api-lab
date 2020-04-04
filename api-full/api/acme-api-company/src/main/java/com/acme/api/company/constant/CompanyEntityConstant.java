package com.acme.api.company.constant;

public final class CompanyEntityConstant {

	private CompanyEntityConstant () {}
	
	/** COMPANY FIELDS **/
	public static final String TABLE_COMPANY = "Company";
	public static final String FIELD_COMPANY_ID = "CompanyId";
	public static final String FIELD_COMPANY_NAME = "CompanyName";
	
	/** COMPANY SEQUENCE **/
	public static final String SEQUENCE_COMPANY_ID_NAME = "CompanySeq";
	public static final int SEQUENCE_COMPANY_ID_INCREMENT = 1;
	public static final String SEQUENCE_COMPANY_ID_NAME_GENERATOR = "companyNameSeq";
		
}
