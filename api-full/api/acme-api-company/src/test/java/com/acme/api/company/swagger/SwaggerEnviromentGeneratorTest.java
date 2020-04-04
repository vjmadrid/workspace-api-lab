package com.acme.api.company.swagger;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.acme.architecture.common.util.RestUtil;
import com.acme.architecture.core.constant.DefaultSpringConfigConstant;
import com.acme.architecture.core.constant.SwaggerConstant;
import com.acme.architecture.core.util.AcmeSwaggerUtil;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(profiles = { DefaultSpringConfigConstant.SPRING_PROFILE_LOCAL })
public class SwaggerEnviromentGeneratorTest {

	@Autowired
	private MockMvc mockMvc;

	@Value("${info.app.name}")
	private String FILE_NAME;

	@Test
	public void createSpringfoxSwaggerJson() throws Exception {

		MvcResult mvcResult = this.mockMvc
				.perform(get(SwaggerConstant.SWAGGER_URL_PATH_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();

		MockHttpServletResponse response = mvcResult.getResponse();

		String swaggerJson = response.getContentAsString();

		// Generates JSON and SWAGGER
		AcmeSwaggerUtil.saveFile(SwaggerConstant.SWAGGER_OUTPUT_DIR_DEFAULT,
				FILE_NAME + SwaggerConstant.SWAGGER_EXTENSION_JSON, swaggerJson);
		AcmeSwaggerUtil.saveFile(SwaggerConstant.SWAGGER_OUTPUT_DIR_DEFAULT,
				FILE_NAME + SwaggerConstant.SWAGGER_EXTENSION_YML, RestUtil.covertJsonToYamlResponse(swaggerJson));
	}

}
