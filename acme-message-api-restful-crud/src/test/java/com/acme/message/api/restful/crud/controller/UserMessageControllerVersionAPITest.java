package com.acme.message.api.restful.crud.controller;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.acme.message.api.restful.crud.constant.UserMessageRestApiConstant;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserMessageControllerVersionAPITest {

	private static final String API_PATH = "/api";
	
	@LocalServerPort
    private int port;

    @Before
    public void setUp() throws Exception {
    	RestAssured.port = this.port;
    }

    @Test
    public void whenCallAPIGetValidId_thenRetrieveNameVersion1InURL() throws Exception {
    	String idTest = "2";
		RestAssured.
			given().
				accept(ContentType.JSON).
			when().
				get(String.format("%s/v1/usermessages/{id}", API_PATH), idTest).
			then().
				statusCode(HttpStatus.SC_OK).
				contentType(ContentType.JSON).
				body("description", Matchers.equalTo(String.format("Test %s %s", "Description", idTest)));
    }
    
    @Test
    public void whenCallAPIGetInvalidId_thenRetrieve400Version1InURL() throws Exception {
    	String idTest = "test";
		RestAssured.
			given().
				accept(ContentType.JSON).
			when().
				get(String.format("%s/v1/usermessages/{id}", API_PATH), idTest).
			then().
				statusCode(HttpStatus.SC_BAD_REQUEST);
    }
	
}
