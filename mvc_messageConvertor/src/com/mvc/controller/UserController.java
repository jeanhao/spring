package com.mvc.controller;

import java.util.Collections;

import net.sf.json.JSONObject;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.mvc.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("getUser")
	public void getUser( @RequestBody User user){//将输入数据转化为User对象
		System.out.println(user);
	}
	
	@RequestMapping("getUser1")
	public void getUser1( HttpEntity<User> userEntity){//将输入数据转化为User对象
		System.out.println(userEntity.getBody());
	}
	@ResponseBody//将输出的java对象转换为合适的相应正文输出
	@RequestMapping("getUser2")
	public User getUser2(User user){
		System.out.println(user);
		return user;
	}
	@RequestMapping("getUser3")
	public HttpEntity<User> getUser3(User user){
		System.out.println(user);
		HttpEntity<User> uEntity = new HttpEntity<User>(user);
		return uEntity;
	}
	public static void main(String args[]){
		User user = new User();
		user.setId(10);
		user.setPassword("myPassword");
		user.setUserName("myUserName");
		JSONObject jsonObject = JSONObject.fromObject(user);
		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.valueOf("application/json;UTF-8"));
		HttpEntity<String> strEntity = new HttpEntity<String>(jsonObject.toString(),headers);

		RestTemplate restTemplate  = new RestTemplate();
		String result = restTemplate.postForObject("http://localhost:8080/springMVC/user/getUser1",strEntity,String.class);
		System.out.println(result);
//		System.out.println(jsonObject);
		
//		RestTemplate restTemplate  = new RestTemplate();
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.valueOf("application/json;UTF-8"));
//		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//		HttpEntity<User> userEntity = new HttpEntity<User>(user,headers);
//		ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8080/springMVC/user/getUser",HttpMethod.GET,userEntity,String.class);
//		System.out.println(responseEntity.getBody());
	}
}
