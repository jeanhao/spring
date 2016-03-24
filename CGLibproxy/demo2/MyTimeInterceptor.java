package com.proxy.demo2;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class MyTimeInterceptor implements MethodInterceptor {

	@Override
	public Object intercept(Object target, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {//拦截所有父类方法的调用
		Long beginTime = System.currentTimeMillis();//记录开始时间
		//调用目标对象的方法，同时获取该方法的返回值，作为我们本代理方法(invoke)的返回值
		Object returnValue = proxy.invokeSuper(target, args);//target为我们方法所在的目标类，args为方法参数
		System.out.println("方法" + method.getName() + "调用结束，耗时"+ (System.currentTimeMillis() - beginTime));
		return returnValue;
	}
	
}
