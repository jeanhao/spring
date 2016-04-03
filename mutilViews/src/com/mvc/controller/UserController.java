package com.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.model.Article;
import com.mvc.model.User;

@Controller
public class UserController {
	
	@RequestMapping("test")
    public ModelAndView test() {
       return new ModelAndView("hello","hello", "hello World!");
    }
	@RequestMapping("views")
	public String views(ModelMap map,HttpServletRequest request){
		List<Article>articles = new ArrayList<Article>();
		for(int i = 0 ; i < 5; i ++){
			Article article = new Article();
			article.setTitle("title" +i);
			article.setContent("content" + i);
			articles.add(article);
		}
		map.addAttribute("articles",articles);
		return "views";
	}
	@RequestMapping("jsonView")
	public String jsonView(ModelMap modelMap ){
		Map<String, String> map = new HashMap<String ,String>();
		for(int i = 0 ; i < 5; i ++){
			map.put("key" + i," value" + i);
		}
		modelMap.put("map", map);//将数据以键名map放入模型中
		return "userJson";//对应json视图的Bean名
	}
	@RequestMapping("xmlView")
	public String xmlView(ModelMap map){
		List<Article>articles = new ArrayList<Article>();
		for(int i = 0 ; i < 5; i ++){
			Article article = new Article();
			article.setTitle("title" +i);
			article.setContent("content" + i);
			articles.add(article);
		}
		map.addAttribute("articles",articles);
		return "myXmlView";
	}
	@RequestMapping("excelView")
	public String excelView(ModelMap map){
		List<Article>articles = new ArrayList<Article>();
		for(int i = 0 ; i < 5; i ++){
			Article article = new Article();
			article.setTitle("title" +i);
			article.setContent("content" + i);
			articles.add(article);
		}
		map.addAttribute("articles",articles);
		return "excelView";
	}
	
}
