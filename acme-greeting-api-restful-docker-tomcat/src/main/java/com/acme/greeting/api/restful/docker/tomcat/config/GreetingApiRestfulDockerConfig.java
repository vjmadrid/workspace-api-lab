package com.acme.greeting.api.restful.docker.tomcat.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.acme.greeting.api.restful.docker.tomcat.constant.GreetingApiRestfulDockerConfigConstant;

@Configuration
@ComponentScan(basePackages = { GreetingApiRestfulDockerConfigConstant.GENERIC_PACKAGE })
public class GreetingApiRestfulDockerConfig {

}
