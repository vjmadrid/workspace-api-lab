package com.acme.message.api.restful.crud.client;
 
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.acme.message.api.restful.crud.constant.UserMessageRestApiConstant;
import com.acme.message.api.restful.crud.entity.UserMessage;
import com.acme.message.api.restful.crud.factory.UserMessageDataFactory; 

public class UserMessageRestApiControllerTestClient {
 
    public static final String REST_SERVICE_URI = "http://localhost:8090/restful-boot"+UserMessageRestApiConstant.MAPPING;
    
    @SuppressWarnings("unchecked")
    private static void listAllUserMessage(){
        System.out.println("**** Test listAllUserMessages API ***");
         
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject(REST_SERVICE_URI, List.class);
         
        if(usersMap!=null){
            for(LinkedHashMap<String, Object> map : usersMap){
                //System.out.println("UserMessage ["+map+"] : id="+map.get(UserMessageConstant.FIELD_ID)+", description="+map.get(UserMessageConstant.FIELD_DESCRIPTION)+", vip="+map.get(UserMessageConstant.FIELD_VIP)+", creationDate="+map.get(UserMessageConstant.FIELD_CREATIONDATE)+", deletedDate="+map.get(UserMessageConstant.FIELD_DELETEDDATE));
            	System.out.println("UserMessage ["+map+"]");
            }
        }else{
            System.out.println("No user exist");
        }
    }
     
    private static void getUserMessage(){
        System.out.println("*** Test getUserMessage API ***");
        RestTemplate restTemplate = new RestTemplate();
        UserMessage userMessage = restTemplate.getForObject(REST_SERVICE_URI+"/1", UserMessage.class);
        System.out.println(userMessage);
    }
        
    private static void createUserMessage() {
        System.out.println("*** Test create UserMessage API ***");
        RestTemplate restTemplate = new RestTemplate();
        UserMessage userMessage = UserMessageDataFactory.create(5,"TEST",true);
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI, userMessage, UserMessage.class);
        System.out.println("Location : "+uri.toASCIIString());
    }
 
    private static void updateUserMessage() {
        System.out.println("*** Testing update UserMessage API ***");
        RestTemplate restTemplate = new RestTemplate();
        UserMessage userMessage = UserMessageDataFactory.create(5,"TEST UPDATED",true);
        restTemplate.put(REST_SERVICE_URI+"/5", userMessage);
        System.out.println(userMessage);
    }
 
    private static void deleteUserMessage() {
        System.out.println("*** Testing delete User API ***");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/1");
    }
    public static void main(String args[]){
//    	listAllUserMessage();
//        getUserMessage();
//        createUserMessage();
//        listAllUserMessage();
//        updateUserMessage();
        listAllUserMessage();
        deleteUserMessage();
        listAllUserMessage();

    }
}