package test.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println(invocation.getArguments()[0] + "——" +
		invocation.getStaticPart() + "——" +
		invocation.getThis().getClass() + "——" +
		invocation.getMethod().getName());
		invocation.proceed();//反射调用目标对象方法
		System.out.println("环绕增强调用结束");
		return "I'm around return value";
	}
	
}
