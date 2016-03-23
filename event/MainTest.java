package test.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	public static void main(String args[]) throws InterruptedException{
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:test/event/event.xml");
		UserService userService = (UserService) ac.getBean("userService");
		Long beginTime = System.currentTimeMillis();
		userService.doLogin("zenghao@google.com","12345678911");//完成注册请求
		System.out.println("处理注册相关业务耗时" + (System.currentTimeMillis() - beginTime )+ "ms");
		System.out.println("处理其他业务逻辑开始..");
		Thread.sleep(500);//模拟处理其他业务请求耗时
		System.out.println("处理其他业务逻辑结束..");
		System.out.println("处理所有业务耗时" + (System.currentTimeMillis() - beginTime )+ "ms");
		System.out.println("向客户端发送注册成功响应");
	}
}
