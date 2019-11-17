package com.acme.message.api.restful.crud.factory.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.acme.message.api.restful.crud.constant.UserMessageConstant;
import com.acme.message.api.restful.crud.dto.UserMessageDTO;
import com.acme.message.api.restful.crud.factory.UserMessageDTODataFactory;

public final class DummyUserMessageDTODataFactory {

	public static UserMessageDTO createSampleDefault() {
		return UserMessageDTODataFactory.create(UserMessageConstant.TEST_USER_MESSAGE_1_ID,UserMessageConstant.TEST_USER_MESSAGE_1_DESCRIPTION, UserMessageConstant.TEST_USER_MESSAGE_1_VIP);
	}
	
	public static Map<Long,UserMessageDTO> createSampleMap() {
		final Map<Long,UserMessageDTO> map = new HashMap<>(); 
		map.put(UserMessageConstant.TEST_USER_MESSAGE_1_ID, UserMessageDTODataFactory.create(UserMessageConstant.TEST_USER_MESSAGE_1_ID,UserMessageConstant.TEST_USER_MESSAGE_1_DESCRIPTION, UserMessageConstant.TEST_USER_MESSAGE_1_VIP));
		map.put(UserMessageConstant.TEST_USER_MESSAGE_2_ID, UserMessageDTODataFactory.create(UserMessageConstant.TEST_USER_MESSAGE_2_ID,UserMessageConstant.TEST_USER_MESSAGE_2_DESCRIPTION, UserMessageConstant.TEST_USER_MESSAGE_2_VIP));
		map.put(UserMessageConstant.TEST_USER_MESSAGE_3_ID, UserMessageDTODataFactory.create(UserMessageConstant.TEST_USER_MESSAGE_3_ID,UserMessageConstant.TEST_USER_MESSAGE_3_DESCRIPTION, UserMessageConstant.TEST_USER_MESSAGE_3_VIP));		
		map.put(UserMessageConstant.TEST_USER_MESSAGE_4_ID, UserMessageDTODataFactory.create(UserMessageConstant.TEST_USER_MESSAGE_4_ID,UserMessageConstant.TEST_USER_MESSAGE_4_DESCRIPTION, UserMessageConstant.TEST_USER_MESSAGE_4_VIP));
		return map;
	}
	
	public static List<UserMessageDTO> createSampleList() {
		final List<UserMessageDTO> list = new ArrayList<>();
		list.add(UserMessageDTODataFactory.create(UserMessageConstant.TEST_USER_MESSAGE_1_ID,UserMessageConstant.TEST_USER_MESSAGE_1_DESCRIPTION, UserMessageConstant.TEST_USER_MESSAGE_1_VIP));
		list.add(UserMessageDTODataFactory.create(UserMessageConstant.TEST_USER_MESSAGE_2_ID,UserMessageConstant.TEST_USER_MESSAGE_2_DESCRIPTION, UserMessageConstant.TEST_USER_MESSAGE_2_VIP));
		list.add(UserMessageDTODataFactory.create(UserMessageConstant.TEST_USER_MESSAGE_3_ID,UserMessageConstant.TEST_USER_MESSAGE_3_DESCRIPTION, UserMessageConstant.TEST_USER_MESSAGE_3_VIP));
		list.add(UserMessageDTODataFactory.create(UserMessageConstant.TEST_USER_MESSAGE_4_ID,UserMessageConstant.TEST_USER_MESSAGE_4_DESCRIPTION, UserMessageConstant.TEST_USER_MESSAGE_4_VIP));
		return list;
	}
	
}
