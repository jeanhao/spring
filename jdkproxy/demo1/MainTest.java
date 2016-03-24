package com.proxy.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MainTest {
	public static void main(String args[]) throws InterruptedException{
		OldClass oldClass = new OldClass();
		InvocationHandler handler = new MyInvocationHandler<OldClass>(oldClass);
		MyProxy myProxy = (MyProxy)Proxy.newProxyInstance(MyProxy.class.getClassLoader(),new Class[]{MyProxy.class},handler);
		myProxy.method1();
		myProxy.method2();
		myProxy.method3();
	}
}
