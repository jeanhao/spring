package test.aop3;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.Ordered;

public class MyAdvice {
	
	public void AfterReturning(Object retInfo) throws Throwable{
		System.out.println("MyAdvice 实施AfterReturning,目标对象方法返回值为:"+retInfo);//返回值为:"+retInfo+"
		
	}
	public void after(String name) throws Throwable{
		System.out.println("MyAdvice 实施after,目标对象方法入参为:"+name);
	}
	public void before(String name) throws Throwable{
		System.out.println("MyAdvice 实施@before,目标对象方法入参为:"+name);
	}
	public void around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("MyAdvice 实施around前,目标对象方法入参为:"+joinPoint.getArgs()[0]);
		joinPoint.proceed();
		System.out.println("MyAdvice 实施around后,目标对象方法入参为:"+joinPoint.getArgs()[0]);
	}
	public void afterThrowing(RuntimeException re) throws Throwable{
		System.out.println("MyAdvice 实施afterThrowing,目标对象方法抛出异常:"+ re.getMessage());
	}
	
	public static void main(String args[]){
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:test/aop3/aop.xml");
		UserController userController = (UserController) ac.getBean("userController");
		userController.login("zenghao");
		userController.logout();
	}
}
