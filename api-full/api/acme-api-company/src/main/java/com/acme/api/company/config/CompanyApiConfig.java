package com.acme.api.company.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.acme.architecture.core.constant.PackageConfigConstant;

@Configuration
@ComponentScan(basePackages = { PackageConfigConstant.COMMON_PACKAGE })
public class CompanyApiConfig {

}
