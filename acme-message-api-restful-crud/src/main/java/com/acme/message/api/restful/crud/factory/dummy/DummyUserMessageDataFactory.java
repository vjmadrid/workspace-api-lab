package com.acme.message.api.restful.crud.factory.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.acme.message.api.restful.crud.constant.UserMessageConstant;
import com.acme.message.api.restful.crud.entity.UserMessage;
import com.acme.message.api.restful.crud.factory.UserMessageDataFactory;

public final class DummyUserMessageDataFactory {

	public static UserMessage createSampleDefault() {
		return UserMessageDataFactory.create(UserMessageConstant.TEST_USER_MESSAGE_1_ID,UserMessageConstant.TEST_USER_MESSAGE_1_DESCRIPTION, UserMessageConstant.TEST_USER_MESSAGE_1_VIP);
	}
	
	public static Map<Long,UserMessage> createSampleMap() {
		final Map<Long,UserMessage> map = new HashMap<>(); 
		map.put(UserMessageConstant.TEST_USER_MESSAGE_1_ID, UserMessageDataFactory.create(UserMessageConstant.TEST_USER_MESSAGE_1_ID,UserMessageConstant.TEST_USER_MESSAGE_1_DESCRIPTION, UserMessageConstant.TEST_USER_MESSAGE_1_VIP));
		map.put(UserMessageConstant.TEST_USER_MESSAGE_2_ID, UserMessageDataFactory.create(UserMessageConstant.TEST_USER_MESSAGE_2_ID,UserMessageConstant.TEST_USER_MESSAGE_2_DESCRIPTION, UserMessageConstant.TEST_USER_MESSAGE_2_VIP));
		map.put(UserMessageConstant.TEST_USER_MESSAGE_3_ID, UserMessageDataFactory.create(UserMessageConstant.TEST_USER_MESSAGE_3_ID,UserMessageConstant.TEST_USER_MESSAGE_3_DESCRIPTION, UserMessageConstant.TEST_USER_MESSAGE_3_VIP));		
		map.put(UserMessageConstant.TEST_USER_MESSAGE_4_ID, UserMessageDataFactory.create(UserMessageConstant.TEST_USER_MESSAGE_4_ID,UserMessageConstant.TEST_USER_MESSAGE_4_DESCRIPTION, UserMessageConstant.TEST_USER_MESSAGE_4_VIP));
		return map;
	}
	
	public static List<UserMessage> createSampleList() {
		final List<UserMessage> list = new ArrayList<>();
		list.add(UserMessageDataFactory.create(UserMessageConstant.TEST_USER_MESSAGE_1_ID,UserMessageConstant.TEST_USER_MESSAGE_1_DESCRIPTION, UserMessageConstant.TEST_USER_MESSAGE_1_VIP));
		list.add(UserMessageDataFactory.create(UserMessageConstant.TEST_USER_MESSAGE_2_ID,UserMessageConstant.TEST_USER_MESSAGE_2_DESCRIPTION, UserMessageConstant.TEST_USER_MESSAGE_2_VIP));
		list.add(UserMessageDataFactory.create(UserMessageConstant.TEST_USER_MESSAGE_3_ID,UserMessageConstant.TEST_USER_MESSAGE_3_DESCRIPTION, UserMessageConstant.TEST_USER_MESSAGE_3_VIP));
		list.add(UserMessageDataFactory.create(UserMessageConstant.TEST_USER_MESSAGE_4_ID,UserMessageConstant.TEST_USER_MESSAGE_4_DESCRIPTION, UserMessageConstant.TEST_USER_MESSAGE_4_VIP));
		return list;
	}
	
}
