package test.aop2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2)
public class Annotation_aspect4{
	
	@Pointcut("target(test.aop2.UserController)")
	private void pointcut(){}
	
	
	@AfterReturning("pointcut()")
	public void AfterReturning() throws Throwable{
		System.out.println("Annotation_aspect4 实施AfterReturning,注解优先级为2");
	}
	@After("pointcut()")
	public void after() throws Throwable{
		System.out.println("Annotation_aspect4 实施after,注解优先级为2");
	}
	@Before("pointcut()")
	public void before() throws Throwable{
		System.out.println("Annotation_aspect4 实施@before,注解优先级为2");
	}
	@Around("pointcut()")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("Annotation_aspect4 实施around前,注解优先级为2");
		joinPoint.proceed();
		System.out.println("Annotation_aspect4 实施around后,注解优先级为2");
	}
	
}
