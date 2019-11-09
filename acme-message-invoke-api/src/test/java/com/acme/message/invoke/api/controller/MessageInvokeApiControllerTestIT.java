package com.acme.message.invoke.api.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.acme.message.invoke.api.constant.MessageInvokeApiConstant;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MessageInvokeApiControllerTestIT {

	@LocalServerPort
    private int port;

    private URL base;
    
    private String templateMessageTest;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
    	templateMessageTest = "answer";
    	
        base = new URL("http://localhost:" + port + MessageInvokeApiConstant.MAPPING);
    }

    @Test
    public void getHello() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base.toString(),String.class);
        
        assertThat(response.getBody(), containsString(templateMessageTest));
    }
	
}