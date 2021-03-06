package com.acme.message.api.restful.crud.config.swagger;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final Contact DEFAULT_CONTACT = new Contact("Victor Madrid", "http://www.acme.corp.com",
			"global@acme.corp.com");

	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Acme Message API Title",
			"Acme Message API Description", "1.0", "urn:tos", DEFAULT_CONTACT, "Apache 2.0",
			"http://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());

//	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(
//			Arrays.asList(MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE));
//	
	@Bean
	public Docket swagger() {
		return new Docket(DocumentationType.SWAGGER_2)  
		          .select()
		          .apis(RequestHandlerSelectors.any())
		          .paths(PathSelectors.any())
		          .build().apiInfo(DEFAULT_API_INFO);
	}

}
