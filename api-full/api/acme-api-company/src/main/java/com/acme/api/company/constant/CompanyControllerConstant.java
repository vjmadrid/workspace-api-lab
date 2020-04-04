package com.acme.api.company.constant;

public final class CompanyControllerConstant {

	private CompanyControllerConstant() {
	}

	/** Company controller path variables **/
	public static final String URL_VAR_ID = "id";
	public static final String URL_VAR_ID_LIST = "ids";

	/** Company controller paths **/
	public static final String BASE_URL = "/companies";
	public static final String GET_BY_ID_PATH = "/{" + URL_VAR_ID + "}";
	public static final String UPDATE_PATH = GET_BY_ID_PATH;
	public static final String BASE_FILTER_URL = BASE_URL + "/filter";
	public static final String BASE_FILTER_LIST_URL = "/list";

	public static final String GET_PAGING = "/page";

}
