package com.mvc.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public abstract class BaseController {
	//准备web资源
	protected ServletContext servletContext;
	protected HttpSession session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	//可以用来读取上传的IO流
	protected BufferedReader bufferedReader;
	//可以用来给安卓、IOS或网页ajax调用输出数据
	protected PrintWriter printWriter;

	@ModelAttribute
	protected void setReqAndRes(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		this.request = request;
		this.response = response;
		this.session = request.getSession();
		this.servletContext = session.getServletContext();
		this.bufferedReader = request.getReader();
		this.printWriter = response.getWriter();
	}
	@RequestMapping("doSth")
	public void doSth(HttpServletRequest request,HttpServletResponse response,BufferedReader bufferedReader,PrintWriter printWriter){
		System.out.println("do something....");
	}
}
