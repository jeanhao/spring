package test.aop2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	public static void main(String args[]) throws Exception{
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:test/aop2/aop.xml");
		UserController userController = (UserController) ac.getBean("userController");
		userController.login("zenghao");
	}
}
