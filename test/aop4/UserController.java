package test.aop4;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UserController {
	public void login(String name){
		System.out.println("I'm "+name+" ,I'm logining");
		
		try {
			Thread.sleep(100);//模拟登陆过程中进行了数据库查询。各种业务逻辑处理的复杂工作
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) throws InterruptedException{
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:test/aop4/aop.xml");
		UserController userController = (UserController) ac.getBean("proxyFactory");
		SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
		TaskActiver taskActiver = (TaskActiver) userController;
		userController.login("zenghao");
		while(true){
			Integer now = Integer.valueOf(sdf.format(new Date()));
			if(now >  0000&& now < 0100 ){//在特定时间内，且未开启任务，则开启
				taskActiver.startTask();
			}else if(now <=  0000 && now >= 0100){//在特定时间外，且未关闭任务，则关闭
				taskActiver.stopTask();
			}
			userController.login("zenghao");
			Thread.sleep(5 * 1000);
			
		}
		
	}
}
