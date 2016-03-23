package test.event2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	public static void main(String args[]) throws InterruptedException{
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:test/event2/event.xml");
		XiaoBai xiaobai = (XiaoBai) ac.getBean("xiaoBai");
		xiaobai.reportWorks();//小白要开始申报项目啦
	}
}
