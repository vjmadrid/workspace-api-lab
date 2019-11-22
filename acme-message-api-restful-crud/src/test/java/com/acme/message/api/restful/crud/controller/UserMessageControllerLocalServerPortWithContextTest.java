package com.acme.message.api.restful.crud.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.acme.message.api.restful.crud.constant.UserMessageRestApiConstant;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserMessageControllerLocalServerPortWithContextTest {
	
	private final int ID_VALID_TEST = 2;
	
	private final int ID_INVALID_TEST = 999;

	@LocalServerPort
    private int port;

    private URL base;
    
    private String templateMessageTest;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        base = new URL("http://localhost:" + port + UserMessageRestApiConstant.MAPPING);
    }

    @Test
    public void whenCallAPIGetValidId_thenRetrieveNameVersion1InURL() throws Exception {
    	final String idMappingTest = String.format(base.toString()+"/%s", ID_VALID_TEST);
    	templateMessageTest = String.format("Test %s %s", "Description", ID_VALID_TEST);
    	
        ResponseEntity<String> responseEntity = template.getForEntity(idMappingTest,String.class);
        
        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
        assertThat(responseEntity.getBody(), containsString(templateMessageTest));
    }
    
    @Test
    public void whenCallAPIGetInvalidId_thenRetrieve400Version1InURL() throws Exception {
    	final String idMappingTest = String.format(base.toString()+"/%s", ID_INVALID_TEST);

        ResponseEntity<String> responseEntity = template.getForEntity(idMappingTest,String.class);
        
        assertEquals(HttpStatus.NOT_FOUND,responseEntity.getStatusCode());
    }
	
	
}
