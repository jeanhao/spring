package test.aop5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mainTest {
	public static void main(String args[]) throws InterruptedException{
	    ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:test/aop5/aop.xml");
	    UserController userController = (UserController) ac.getBean("userController");
	    TaskActiver taskActiver = (TaskActiver) userController;
	    System.out.println(taskActiver instanceof UserController);
	    System.out.println(userController instanceof TaskActiver);
	    taskActiver.startTask();
	    userController.login("zenghao");
	}
}
