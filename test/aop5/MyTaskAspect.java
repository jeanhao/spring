package test.aop5;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Aspect
public class MyTaskAspect {
	
	@DeclareParents(value = "test.aop5.UserController",defaultImpl = MyTaskController.class)
	public TaskActiver taskActiver;
	
	
}
