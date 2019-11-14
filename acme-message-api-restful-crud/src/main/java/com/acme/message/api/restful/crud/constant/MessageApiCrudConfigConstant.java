package com.acme.message.api.restful.crud.constant;

public final class MessageApiCrudConfigConstant {

	private MessageApiCrudConfigConstant() {
	}
	
	public static final String GENERIC_PACKAGE = "com.acme.message";
	public static final String BASE_PACKAGE = GENERIC_PACKAGE + ".api.restful.crud";
	
	public static final String ENTITY_PACKAGE = BASE_PACKAGE + ".entity";
	public static final String DOMAIN_PACKAGE = BASE_PACKAGE + ".domain";
	public static final String REPOSITORY_PACKAGE = BASE_PACKAGE + ".repository";
	public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";
	public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".controller";
	
}
