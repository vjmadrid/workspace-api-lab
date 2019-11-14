package com.acme.message.api.restful.crud.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.acme.message.api.restful.crud.constant.MessageApiCrudConfigConstant;

@Configuration
@ComponentScan(basePackages = { MessageApiCrudConfigConstant.GENERIC_PACKAGE })
public class MessageApiCrudConfig {

}
