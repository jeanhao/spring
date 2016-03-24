package com.proxy.demo2;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class MyRecordInterceptor implements MethodInterceptor {

	@Override
	public Object intercept(Object target, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {// 拦截所有父类方法的调用
		System.out.println(args[0] + "在"
				+ new SimpleDateFormat("yyyy-MM-dd HH-mm").format(new Date())
				+ "调用了方法" + method.getName());
		Object returnValue = proxy.invokeSuper(target, args);// target为我们方法所在的目标类，args为方法参数
		return returnValue;
	}

}
