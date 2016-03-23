package test.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BeforeAdvice implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		System.out.println("前置日志记录："+target+ "调用了"+method.getName() + "方法,传入的第一个参数为："+args[0]);
	}

}
