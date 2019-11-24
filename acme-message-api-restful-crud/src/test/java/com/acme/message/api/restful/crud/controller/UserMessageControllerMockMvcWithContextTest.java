package com.acme.message.api.restful.crud.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.acme.message.api.restful.crud.constant.UserMessageConstant;
import com.acme.message.api.restful.crud.constant.UserMessageRestApiConstant;
import com.acme.message.api.restful.crud.entity.UserMessage;
import com.acme.message.api.restful.crud.factory.UserMessageDataFactory;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserMessageControllerMockMvcWithContextTest {

	private final int ID_INVALID_TEST = 999;

	@Autowired
	private MockMvc mockMvc;

	private UserMessage userMessageTest;

	@Test
	public void whenCallAPIGetValidId_thenRetrieveNameVersion1InURL() throws Exception {
		final String idMappingTest = String.format(UserMessageRestApiConstant.MAPPING + "/%s",
				UserMessageConstant.TEST_USER_MESSAGE_2_ID);
		final String descriptionResult = String.format("Test %s %s", "Description",
				UserMessageConstant.TEST_USER_MESSAGE_2_ID);

		mockMvc.perform(get(idMappingTest)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.description").value(descriptionResult));
	}

	@Test
	public void whenCallAPIGetInvalidId_thenRetrieve400Version1InURL() throws Exception {
		final String idMappingTest = String.format(UserMessageRestApiConstant.MAPPING + "/%s", ID_INVALID_TEST);

		mockMvc.perform(get(idMappingTest)).andDo(print()).andExpect(status().isNotFound());
	}

	@Test
	public void whenCallAPIPost_thenRetrieve201Version1InURL() throws Exception {
		userMessageTest = UserMessageDataFactory.create("Test Description", false);
		userMessageTest.setCreationDate(null);

		mockMvc.perform(post(UserMessageRestApiConstant.MAPPING).content(userMessageTest.toString())
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}

	@Test
	public void whenCallAPIPutValidId_thenRetrieve200Version1InURL() throws Exception {
		userMessageTest = UserMessageDataFactory.create("Test Description", false);

		mockMvc.perform(put(UserMessageRestApiConstant.MAPPING + "/{id}", UserMessageConstant.TEST_USER_MESSAGE_1_ID)
				.content(userMessageTest.toString()).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.description").value("Test Description"));
	}

	@Test
	public void whenCallAPIPutInvalidId_thenRetrieve400Version1InURL() throws Exception {
		userMessageTest = UserMessageDataFactory.create("Test Description", false);

		mockMvc.perform(
				put(UserMessageRestApiConstant.MAPPING + "/{id}", ID_INVALID_TEST).content(userMessageTest.toString())
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}

	@Test
	public void whenCallAPIDeleteValidId_thenRetrieve200Version1InURL() throws Exception {
		mockMvc.perform(delete(UserMessageRestApiConstant.MAPPING + "/{id}", UserMessageConstant.TEST_USER_MESSAGE_4_ID)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	public void whenCallAPIDeleteInvalidId_thenRetrieve400Version1InURL() throws Exception {
		mockMvc.perform(delete(UserMessageRestApiConstant.MAPPING + "/{id}", ID_INVALID_TEST)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
	}

}
