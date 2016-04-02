package com.mvc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.mvc.model.SuperUser;
import com.mvc.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	@RequestMapping("convert")
	public String convert( User user){
		System.out.println(user);
		return "model1";
	}
	@RequestMapping("convertSuper")
	public String convert( SuperUser user){
		System.out.println(user);
		return "model1";
	}
}
