package com.acme.message.api.restful.crud.config.environment;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.acme.message.api.restful.crud.config.constant.DefaultSpringConfigConstant;

@Configuration
@Profile(DefaultSpringConfigConstant.SPRING_PROFILE_DEVELOPMENT)
public class DevelopmentConfig {
	
	private static final Logger LOG = LoggerFactory.getLogger(DevelopmentConfig.class);
	
	@PostConstruct
	public void setup () {
		LOG.debug("[CONFIGURATION] DEV Environment ...");
	}
    
}