package com.proxy.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
//这里我们使用了泛型，假设我们有很多的类都需要进行性能监控，就可以通过在创建本类对象时在泛型标识处改成对应需要监控的类即可。
//注意需要实现JDK反射包中的InvocationHandler接口
public class MyInvocationHandler<E> implements InvocationHandler {
	//需要被代理的对象
	private E target;
	
	public MyInvocationHandler(E target){
		this.target = target;
	}
	/**
	 * @param：
    *  proxy : 在其上调用方法的代理实例
    *  method : 对应于在目标对象调用的方法。
    *  args : 包含传入代理实例上方法调用的参数值的对象数组，如果接口方法不使用参数，则为 null
    *           基本类型的参数被包装在适当基本包装器类（如 java.lang.Integer 或 java.lang.Boolean）的实例中。 
	*  @return  从代理实例的方法调用返回的值。如果接口方法的声明返回类型是基本类型，
*  			则此方法返回的值一定是相应基本包装对象类的实例；否则，它一定是可分配到声明返回类型的类型。
    *  		如果此方法返回的值为 null 并且接口方法的返回类型是基本类型，则代理实例上的方法调用将抛出 NullPointerException
    *  		否则，如果此方法返回的值与上述接口方法的声明返回类型不兼容，则代理实例上的方法调用将抛出 ClassCastException。 
    *  @throws  Throwable - 从代理实例上的方法调用抛出的异常。
	*  		 该异常的类型必须可以分配到在接口方法的 throws 子句中声明的任一异常类型
	*  		 或未经检查的异常类型 java.lang.RuntimeException 或 java.lang.Error。
	* 			 如果此方法抛出经过检查的异常，该异常不可分配到在接口方法的 throws 子句中声明的任一异常类型.
	*   		 代理实例的方法调用将抛出包含此方法曾抛出的异常的 UndeclaredThrowableException。
	*/
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Long beginTime = System.currentTimeMillis();//记录开始时间
		//调用目标对象的方法，同时获取该方法的返回值，作为我们本代理方法(invoke)的返回值
		Object returnValue = method.invoke(target, args);//target为我们方法所在的目标类，args为方法参数
		System.out.println("方法" + method.getName() + "调用结束，耗时"+ (System.currentTimeMillis() - beginTime));
		return returnValue;
	}

}
