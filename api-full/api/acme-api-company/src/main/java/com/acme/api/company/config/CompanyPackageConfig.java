package com.acme.api.company.config;

import org.springframework.context.annotation.Configuration;

import com.acme.architecture.core.config.PackageConfig;

@Configuration
public class CompanyPackageConfig extends PackageConfig {

	public CompanyPackageConfig() {
		super("api.company");
	}

}
