package com.mvc.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.Conventions;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.RedirectView;

import com.mvc.model.User;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController2 {
	
//	@ModelAttribute
//	public User getUser(){//我们使用map类型存储的数据一样会被绑定到model中
//		return new User(1,"myUserName1","myPwd1");
//	} 
	
	@RequestMapping("req1")
	public String req1(HttpSession session,@ModelAttribute User user){
		user.setId(1);
		user.setPassword("myPassword");
		user.setUserName("myUserName");
		
		
//		session.setAttribute("newUser", user);
		return "redirect:req2";
	}
	@RequestMapping("req2")
	public String req2(ModelMap modelMap,HttpSession session){
		User user = (User) modelMap.get("user");
//		User newUser = (User) modelMap.get("newUser");
		System.out.println("user from model :" + user);
//		System.out.println("newUser from model :" + newUser);
		
		User suser = (User) session.getAttribute("user");
//		User snewUser = (User) session.getAttribute("newUser");
		System.out.println("user from session :" + suser);
//		System.out.println("newUser from session :" + snewUser);
		return "model1";
	}
	
}
