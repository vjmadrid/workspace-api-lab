package com.acme.greeting.api.restful.full.build.client;
 
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.acme.greeting.api.restful.full.build.constant.GreetingRestApiConstant; 

public class ExampleTestClient {
 
    public static final String REST_SERVICE_URI = "http://localhost:8090";
    
    private URL base;
    
    private String templateMessageTest;
    
    private TestRestTemplate restTemplate;
    
    @Before
    public void setUp() throws Exception {
    	RestTemplate restTemplate = new RestTemplate();
    	templateMessageTest = String.format(GreetingRestApiConstant.TEMPLATE_MESSAGE, GreetingRestApiConstant.DEFAUL_VALUE_PK);
    	
        base = new URL(REST_SERVICE_URI + GreetingRestApiConstant.MAPPING);
    }

    @Test
    public void getHello() throws Exception {
        ResponseEntity<String> response = restTemplate.getForEntity(base.toString(),String.class);
        
        assertThat(response.getBody(), containsString(templateMessageTest));
    }
    
}