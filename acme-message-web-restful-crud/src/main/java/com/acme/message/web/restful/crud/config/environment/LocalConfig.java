package com.acme.message.web.restful.crud.config.environment;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.acme.message.web.restful.crud.config.constant.DefaultSpringConfigConstant;

@Configuration
@Profile(DefaultSpringConfigConstant.SPRING_PROFILE_LOCAL)
public class LocalConfig {
	
	private static final Logger LOG = LoggerFactory.getLogger(LocalConfig.class);
	
	@PostConstruct
	public void setup () {
		LOG.debug("[CONFIGURATION] LOCAL Environment ...");
	}
    
}