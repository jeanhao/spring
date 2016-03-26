package test;

import java.util.Iterator;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.interceptor.TransactionProxyFactoryBean;

import com.yc.service.MyBaseService;
import com.yc.service.MyBaseServiceImpl;
public class Test1 {
//	@Test
	public void test1(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/spring-task.xml");
		JobDetail jobDetail = (JobDetail) ac.getBean("myJobDetail");
		System.out.println(jobDetail.getDescription());
		System.out.println(jobDetail.getFullName());
		System.out.println(jobDetail.getGroup());
		System.out.println(jobDetail.getName());
		System.out.println(jobDetail.getJobClass());
		String[] listenerNames = jobDetail.getJobListenerNames();
		for(String name : listenerNames){
			System.out.println(name);
		}
		Map map = jobDetail.getJobDataMap();
		for(Iterator it = map.keySet().iterator(); it.hasNext();){
			Object key = it.next();
			System.out.println( key + "——" + map.get(key));
		}
	}
//	@Test
	public void test2(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/spring-task.xml");
		JobDetail jobDetail = (JobDetail) ac.getBean("myJobFactoryBean");
		System.out.println(jobDetail.getDescription());
		System.out.println(jobDetail.getFullName());
		System.out.println(jobDetail.getGroup());
		System.out.println(jobDetail.getName());
		System.out.println(jobDetail.getJobClass());
		String[] listenerNames = jobDetail.getJobListenerNames();
		for(String name : listenerNames){
			System.out.println(name);
		}
		Map map = jobDetail.getJobDataMap();
		for(Iterator it = map.keySet().iterator(); it.hasNext();){
			Object key = it.next();
			System.out.println( key + "——" + map.get(key));
		}
	}
	
//	@Test
	public void test3(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/spring-task.xml");
		SimpleTrigger simpleTrigger= (SimpleTrigger) ac.getBean("mySimpleTrigger");
		System.out.println("name = " + simpleTrigger.getName());
		System.out.println("group = " + simpleTrigger.getGroup());
		System.out.println("jobGroup = " + simpleTrigger.getJobGroup());
		System.out.println("jobName = " + simpleTrigger.getJobName());
		System.out.println("jobDataMap = " + simpleTrigger.getJobDataMap());
		System.out.println("fullName = " +  simpleTrigger.getFullName());
		System.out.println("fullJobName = " + simpleTrigger.getFullJobName());
		System.out.println("repearCount = " + simpleTrigger.getRepeatCount());
		System.out.println("repeatInterval = " + simpleTrigger.getRepeatInterval());
		System.out.println("TimesTriggered = " + simpleTrigger.getTimesTriggered());//被触发次数
		System.out.println("nextFireTime = " + simpleTrigger.getNextFireTime());//下次触发时间，如果不会再触发，则为null
		System.out.println("previousFireTime = " + simpleTrigger.getPreviousFireTime());//上次触发时间，如果还没开始触发，则为null
		System.out.println("startTime = " +  simpleTrigger.getStartTime());//开始时间
		System.out.println("finalFireTime = " + simpleTrigger.getFinalFireTime());//最后触发时间
	}
	
	@Test
	public void test4() throws InterruptedException{
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/spring-task.xml");
		Thread.sleep(100000);
	}
}