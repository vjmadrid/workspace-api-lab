package com.acme.message.invoke.api.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.acme.message.invoke.api.constant.MessageInvokeApiConstant;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MessageInvokeApiControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getMessage() throws Exception {
		mockMvc.perform(get(MessageInvokeApiConstant.MAPPING)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.answer").isString());
	}


}
