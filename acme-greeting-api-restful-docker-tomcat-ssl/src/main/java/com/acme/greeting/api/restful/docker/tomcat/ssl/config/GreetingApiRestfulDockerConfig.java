package com.acme.greeting.api.restful.docker.tomcat.ssl.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.acme.greeting.api.restful.docker.tomcat.ssl.constant.GreetingApiRestfulDockerConfigConstant;

@Configuration
@ComponentScan(basePackages = { GreetingApiRestfulDockerConfigConstant.GENERIC_PACKAGE })
public class GreetingApiRestfulDockerConfig {

}
