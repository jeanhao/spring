package test.aop;

import java.lang.reflect.Method;
import java.sql.SQLException;

import org.springframework.aop.ThrowsAdvice;

public class ExceptionAdvice implements ThrowsAdvice {
	public void AfterThrowing(SQLException e){
		System.out.println(e.getMessage());
	}
	public void AfterThrowing(RuntimeException e){
		System.out.println(e.getMessage());
	}
	public void AfterThrowing(Method method, Object[] args, Object target,SQLException e){
		System.out.println(e.getMessage());
	}
}
