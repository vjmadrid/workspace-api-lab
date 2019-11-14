package com.acme.message.api.restful.crud.constant;

public final class PersistenceConfigConstant {

	private PersistenceConfigConstant() {
	}

	public static final String PROP_DATABASE_DRIVER = "datasource.driverClassName";
	public static final String PROP_DATABASE_URL = "datasource.url";
	public static final String PROP_DATABASE_USERNAME = "datasource.username";
	public static final String PROP_DATABASE_PASSWORD = "datasource.password";
	
	public static final String PROP_JNDI = "jdbc.jndiDataSource";
	
	public static final String PROP_HIBERNATE_DIALECT = "hibernate.dialect";
	public static final String PROP_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	public static final String PROP_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
	

}
