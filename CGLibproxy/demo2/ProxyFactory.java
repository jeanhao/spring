package com.proxy.demo2;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;

public class ProxyFactory {
	private Enhancer enhancer = new Enhancer();//动态的类生成器
	public Object createSubObject(Class<?> clazz){
		enhancer.setSuperclass(clazz);//设置需要创建的类，这个类的父类是clazz类
		//当通过enhancer创建的类中的方法被调用时，该方法会被CallBack指定的对象拦截。
		enhancer.setCallbacks(new Callback[]{new MyTimeInterceptor(),new MyRecordInterceptor()});
		enhancer.setCallbackFilter(new MyCallBackFilter());//设置我们自定义的过滤器
		return enhancer.create();//通过字节码技术动态创建子类实例
	}
}
