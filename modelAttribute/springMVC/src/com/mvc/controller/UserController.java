package com.mvc.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.RedirectView;

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
	public User getUser2(User user,HttpServletRequest request){
		Map<String,String[]> map = request.getParameterMap();
		System.out.println(map.size());
		for(Entry<String, String[]> entry : map.entrySet()){
			System.out.println(entry.getKey());
		}
		System.out.println(user);
		return user;
	}
	@RequestMapping("getUser3")
	public HttpEntity<User> getUser3(User user){
		System.out.println(user);
		HttpEntity<User> uEntity = new HttpEntity<User>(user);
		return uEntity;
	}
	@RequestMapping("mav")
	public ModelAndView mav(Model model,ModelMap map){
		ModelAndView mav = new ModelAndView();
		mav.addObject("test");
		mav.addObject("test2");
		mav.addObject(1);
		return mav;
	}
	
	@ModelAttribute
	public User getUser1(){
		System.out.println("getUser1方法被调用");
		return new User(1,"myUserName1","myPwd1");
	}
	@ModelAttribute
	public User getUser2(){
		System.out.println("getUser2方法被调用");
		return new User(2,"myUserName2","myPwd2");
	}
	
	
//	@RequestMapping("model1")
//	public String model1(){//绑定user属性到视图中
//		return "model1";//直接返回视图名，springMVC会帮我们解析成/WEB-INF/views/model1.jsp视图文件
//	}
//	
//	@RequestMapping("model2")
//	public String model2(@ModelAttribute User user){//绑定user属性到视图中
//		user = new User(2,"myUserName","myPwd");
//		return "model1";
//	}
	
	@ModelAttribute
	public void getUser3(Map map){//我们使用map类型存储的数据一样会被绑定到model中
		System.out.println("getUser3方法被调用");
		map.put("user1",new User(1,"myUserName1","myPwd1"));
		map.put("user2",new User(2,"myUserName2","myPwd2"));
	}
	@RequestMapping("model3")
	public String model3(Model model){//我们可以在这绑定入参model读取前面的数据
		System.out.println(model.asMap().get("user1"));
		System.out.println(model.asMap().get("user2"));
		return "model3";
	}
	@RequestMapping("model4")
	public String model4(HashMap map){//我们可以在这绑定入参map的任意实现类读取前面的数据
		System.out.println(map.get("user1"));
		System.out.println(map.get("user2"));
		return "model3";
	}
	@RequestMapping("model5")
	public String model4(ModelMap map){//我们可以在这绑定入参modelMap读取前面的数据
		System.out.println(map.get("user1"));
		System.out.println(map.get("user2"));
		return "model3";
	}
	
	
	public static void main(String args[]){
		User user = new User();
		user.setId(10);
		user.setPassword("myPassword");
		user.setUserName("myUserName");
//		JSONObject jsonObject = JSONObject.fromObject(user);
//		System.out.println(jsonObject);
		
//		String user = "{\"id\":10,\"password\":\"myPassword\",\"userName\":\"myUserName\"}";
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.valueOf("application/json;UTF-8"));
//		HttpEntity<String> strEntity = new HttpEntity<String>(user,headers);
//		RestTemplate restTemplate  = new RestTemplate();
//		String result = restTemplate.postForObject("http://localhost:8080/springMVC/user/getUser1",strEntity,String.class);
//		System.out.println(result);
//		System.out.println(jsonObject);
		
//		MultiValueMap<String, Object> form = new LinkedMultiValueMap<String,Object>();
//		HttpEntity<User> uEntity = new HttpEntity<User>(user);
		RestTemplate restTemplate  = new RestTemplate();
//		String result = restTemplate.postForObject("http://localhost:8080/springMVC/user/getUser2?id={1}&password={2}&userName={3}"
//				,null,String.class,10,"myPassword","myUserName");
//		System.out.println(result);
//		
		ResponseEntity<User> result2 = restTemplate.postForEntity("http://localhost:8080/springMVC/user/getUser2?id={1}&password={2}&userName={3}"
				,null,User.class,10,"myPassword","myUserName");
		System.out.println(result2.getBody());
	}
}
