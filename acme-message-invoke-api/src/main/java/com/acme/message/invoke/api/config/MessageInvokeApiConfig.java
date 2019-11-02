package com.acme.message.invoke.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.acme.message.invoke.api.constant.MessageInvokeApiConfigConstant;

@Configuration
@ComponentScan(basePackages = { MessageInvokeApiConfigConstant.GENERIC_PACKAGE })
public class MessageInvokeApiConfig {

}
