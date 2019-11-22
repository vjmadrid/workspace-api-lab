package com.acme.message.web.restful.crud.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.acme.message.web.restful.crud.config.constant.MessageWebCrudConfigConstant;

@Configuration
@ComponentScan(basePackages = { MessageWebCrudConfigConstant.GENERIC_PACKAGE })
public class MessageWebCrudConfig {

}
