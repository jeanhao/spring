package test.aop2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;

@Aspect
public class Annotation_aspect implements Ordered {
	
	@Pointcut("target(test.aop2.UserController)")
	private void pointcut(){}
	
	
	@AfterReturning("pointcut()")
	public void AfterReturning() throws Throwable{
		System.out.println("Annotation_aspect 实施AfterReturning,优先级为" + getOrder());
	}
	@After("pointcut()")
	public void after() throws Throwable{
		System.out.println("Annotation_aspect 实施after,优先级为" + getOrder());
	}
	@Before("pointcut()")
	public void before() throws Throwable{
		System.out.println("Annotation_aspect 实施@before,优先级为" + getOrder());
	}
	@Around("pointcut()")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("Annotation_aspect 实施around前,优先级为" + getOrder());
		joinPoint.proceed();
		System.out.println("Annotation_aspect 实施around后,优先级为" + getOrder());
	}
	
	@Override
	public int getOrder() {
		return 1;
	}

}
