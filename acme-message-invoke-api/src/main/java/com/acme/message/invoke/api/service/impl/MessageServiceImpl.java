package com.acme.message.invoke.api.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.acme.message.invoke.api.config.InvokeProperties;
import com.acme.message.invoke.api.service.MessageService;

@Service("messageService")
public class MessageServiceImpl implements MessageService {

	private final Logger LOG = LoggerFactory.getLogger(MessageServiceImpl.class);
	
	@Autowired
    private InvokeProperties invokeProperties;
	
	private RestTemplate restTemplate;
	
	@Override
	public String generate() {
		LOG.debug("Generate ...");
		
		String URI = invokeProperties.getEndpoint();
		LOG.debug(" [*] URI :: {}",URI);
		
		return invokeURL(URI);
	}
	
	private String invokeURL(String endpoint) {
		LOG.debug("Invoke URL ...");
		
		restTemplate = new RestTemplate();
		String response = restTemplate.getForObject(endpoint, String.class);
				
		LOG.debug(" [*] Result :: {}",response);
		
		return response.toString();
	}

}
