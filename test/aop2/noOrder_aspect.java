package test.aop2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class noOrder_aspect {
	
	@Pointcut("target(test.aop2.UserController)")
	private void pointcut(){}
	
	
	@AfterReturning("pointcut()")
	public void AfterReturning() throws Throwable{
		System.out.println("noOrder_aspect 实施AfterReturning,无优先级");
	}
	@After("pointcut()")
	public void after() throws Throwable{
		System.out.println("noOrder_aspect 实施after,无优先级");
	}
	@Before("pointcut()")
	public void before() throws Throwable{
		System.out.println("noOrder_aspect 实施@before,无优先级");
	}
	@Around("pointcut()")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("noOrder_aspect 实施around前,无优先级");
		joinPoint.proceed();
		System.out.println("noOrder_aspect 实施around后,无优先级");
	}
}
