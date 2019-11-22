package com.acme.message.api.restful.crud.controller;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.acme.message.api.restful.crud.constant.UserMessageRestApiConstant;
import com.acme.message.api.restful.crud.entity.UserMessage;
import com.acme.message.api.restful.crud.factory.dummy.DummyUserMessageDataFactory;
import com.acme.message.api.restful.crud.service.UserMessageService;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest
public class UserMessageControllerMockMvcWithMockBeanTest {

	private final int ID_TEST = 1;
	
	private UserMessage userMessageTest;
	
	private List<UserMessage> userMessageListTest;
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserMessageService userMessageService;
	
	@Before
	public final void setUp() throws Exception {
		userMessageTest = DummyUserMessageDataFactory.createSampleDefault();
		
		List<UserMessage> userMessageListTest = Arrays.asList(userMessageTest);
        
		given(userMessageService.findByPK(anyLong())).willReturn(Optional.of(userMessageTest));
		given(userMessageService.findAll()).willReturn(userMessageListTest);
		
	}
	
	@Test
	public void whenCallAPIGetValidId_thenRetrieveNameVersion1InURL() throws Exception {
		final String idMappingTest = String.format(UserMessageRestApiConstant.MAPPING+"/%s", ID_TEST);
		final String descriptionResult = String.format("Test %s %s", "Description", ID_TEST);
		
		mockMvc.perform(get(idMappingTest)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.description").value(descriptionResult));
	}
	
	@Test
	public void whenCallAPIGetInvalidId_thenRetrieve400Version1InURLL() throws Exception {
		userMessageTest = null;
		given(userMessageService.findByPK(anyLong())).willReturn(Optional.ofNullable(userMessageTest));
		
		final String idMappingTest = String.format(UserMessageRestApiConstant.MAPPING+"/%s", ID_TEST);

		mockMvc.perform(get(idMappingTest)).andDo(print()).andExpect(status().isNotFound());
	}

}
