package com.mvc.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.Locale;
import java.util.UUID;

import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//@Controller//注解为控制器，通过spring容器扫描，会注册为一个Bean
@RequestMapping("/user")//一级访问路径，对类中所有方法生效
public class UserController1 {
	@RequestMapping("/hello")//二级访问路径
	public String hello(){
		return "hello";//返回视图文件名
	}
	//占位符实例
	@RequestMapping("article/{aid}")
	public String detail(@PathVariable(value = "uid")Integer uid,@PathVariable("aid")Integer aid){
		System.out.println( "查看id为" + uid + "的用户文章，且文章id为"+aid);
		return null;
	}
	
	//*号不同位置和数量示例
	@RequestMapping("u1/*")
	public void test(HttpServletResponse response) throws IOException{
		response.getWriter().print("u1/*");
	}
	
	@RequestMapping("u2/a*")
	public void test1(HttpServletResponse response) throws IOException{
		response.getWriter().print("u2/a*");
	}
	
	//优先级匹配示例
	@RequestMapping("test/**")
	public void test2(HttpServletResponse response) throws IOException{
		response.getWriter().print("test/**");
	}
	@RequestMapping("test/*")
	public void test3(HttpServletResponse response) throws IOException{
		response.getWriter().print("test/*");
	}
	@RequestMapping("test/*/**")
	public void test4(HttpServletResponse response) throws IOException{
		response.getWriter().print("test/*/**");
	}
	@RequestMapping("test/*/*")
	public void test5(HttpServletResponse response) throws IOException{
		response.getWriter().print("test/*/*");
	}
	@RequestMapping("test/1/*")
	public void test6(HttpServletResponse response) throws IOException{
		response.getWriter().print("test/1/*");
	}
	@RequestMapping("test/1/2")
	public void test7(HttpServletResponse response) throws IOException{
		response.getWriter().print("test/1/2");
	}
	//占位符优先级更高
	@RequestMapping("test/1/{id}")
	public void test8(HttpServletResponse response,@PathVariable Integer id ) throws IOException{
		response.getWriter().print("test/1/(myId=)" + id );
	}
	//请求头信息匹配示例
	@RequestMapping(value = "testa",method = RequestMethod.POST,params = {"id1","id2"},headers = "content-type=text/*")
	public void test9(){
	}

	@RequestMapping(value = "testb" ,consumes="application/json")
	public void test10(){
	}
	@RequestMapping(value = "/testc", produces="application/json")
	public void test11(){
	}
	//参数匹配实例
	@RequestMapping(value = "testd",method = RequestMethod.GET,params = {"id1","id2"})
	public void test12(HttpServletResponse response,Integer id1,Integer id2) throws IOException{
		response.getWriter().print(id1 + "——" + id2);
	}
	//方法签名参数绑定示例
	@RequestMapping("test13")
	public void test13(Integer id){
		System.out.println(id);
	}
	
	@RequestMapping("login")
	public void login(@RequestParam(value = "userName",required = true) String userName,
			@RequestParam(value = "password",required = true) String pwd){
	    System.out.println(userName + "-" + pwd);
	}
	@RequestMapping("list")
	public void list(@RequestParam(value = "pageNow",required = false , defaultValue = "1") Integer pageNow){
	    System.out.println(pageNow);
	}
	@RequestMapping("cookie")
	public void cookie(@CookieValue(value = "JSESSIONID",required = false) String cookie ){
	    System.out.println(cookie);
	}
	
	@RequestMapping("headerInfo")
	public void headerInfo(@RequestHeader("Accept-Encoding") String Encoding,
			@RequestHeader("Accept-Language") String Language,
			@RequestHeader("Connection") String Connection,
			@RequestHeader("Host") String Host,
			@RequestHeader("User-Agent") String Agent
			){
		System.out.println(Language);
		System.out.println(Connection);
		System.out.println(Host);
		System.out.println(Agent);
	}
	@RequestMapping("IO")
	public void IO(BufferedReader reader,PrintWriter printWriter ){
	    System.out.println(reader);//输出org.apache.catalina.connector.CoyoteReader@368433b8
	    System.out.println(printWriter);//输出org.apache.catalina.connector.CoyoteWriter@215f90fe
	}
	@RequestMapping("IO2")
	public void IO2(InputStream inputStream,OutputStream outputStream){
	    System.out.println(inputStream);//输出org.apache.catalina.connector.CoyoteInputStream@3c37a4ed
	    System.out.println(outputStream);//输出org.apache.catalina.connector.CoyoteOutputStream@692ce27d
	}
	@RequestMapping("IO3")
	public void IO3(InputStream inputStream,BufferedReader reader){
	    System.out.println(inputStream);
	    System.out.println(reader);
	    //报错java.lang.IllegalStateException: getInputStream() has already been called for this request
	}
	@RequestMapping("IO4")
	public void IO4(PrintWriter printWriter ,OutputStream outputStream){
	    System.out.println(printWriter);
	    System.out.println(outputStream);
	    //报错java.lang.IllegalStateException: getWriter() has already been called for this response
	}
	
	@RequestMapping("other")
	public void other(Locale locale,HttpServletRequest request){
		System.out.println(locale.getCountry());
	}
	@RequestMapping("httpEntity")
	public void httpEntity(HttpEntity<String> httpEntity ){
		System.out.println(httpEntity.getHeaders());
		System.out.println(httpEntity.getBody());
	}
	
}
