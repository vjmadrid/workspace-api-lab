package com.acme.greeting.api.restful.wso2is.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.acme.greeting.api.restful.wso2is.constant.GreetingApiRestfulConfigConstant;

@Configuration
@ComponentScan(basePackages = { GreetingApiRestfulConfigConstant.GENERIC_PACKAGE })
public class GreetingApiRestfulConfig {

}
