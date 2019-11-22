package com.acme.message.api.restful.crud.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.acme.message.api.restful.crud.constant.UserMessageRestApiConstant;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserMessageControllerMockMvcWithContextTest {

	private final int ID_VALID_TEST = 2;
	
	private final int ID_INVALID_TEST = 999;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void whenCallAPIGetValidId_thenRetrieveNameVersion1InURL() throws Exception {
		final String idMappingTest = String.format(UserMessageRestApiConstant.MAPPING+"/%s", ID_VALID_TEST);
		final String descriptionResult = String.format("Test %s %s", "Description", ID_VALID_TEST);
		
		mockMvc.perform(get(idMappingTest)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.description").value(descriptionResult));
	}
	
	@Test
	public void whenCallAPIGetInvalidId_thenRetrieve400Version1InURL() throws Exception {
		final String idMappingTest = String.format(UserMessageRestApiConstant.MAPPING+"/%s", ID_INVALID_TEST);

		mockMvc.perform(get(idMappingTest)).andDo(print()).andExpect(status().isNotFound());
	}

}
