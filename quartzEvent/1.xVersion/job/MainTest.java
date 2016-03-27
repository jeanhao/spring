package tool.job;

import org.quartz.JobDetail;
import org.quartz.JobListener;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SchedulerListener;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerListener;
import org.quartz.impl.StdSchedulerFactory;

public class MainTest {
	public static void main(String args[]) throws SchedulerException {
		JobDetail pickNewsJob =new JobDetail("job1", "jgroup1", PickNewsJob.class); 
		JobDetail getHottestJob =new JobDetail("job2", "jgroup2", GetHottestJob.class);
		SimpleTrigger pickNewsTrigger = new SimpleTrigger("trigger1", "group1",1,2000);
		SimpleTrigger getHottestTrigger = new SimpleTrigger("trigger2", "group2",1,3000);
		
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();
		JobListener myJobListener = new MyJobListener();
		/**********局部Job监听器配置**********/
		pickNewsJob.addJobListener("myJobListener");//这里的名字和myJobListener中getName()方法的名字一样
		scheduler.addJobListener(myJobListener);//向scheduler注册我们的监听器
		/*********全局Job监听器配置************/
//		scheduler.addGlobalJobListener(myJobListener);//直接添加为全局监听器
		
		TriggerListener myTriggerListener = new MyTriggerListener();
		/**********局部Trigger监听器配置**********/
		pickNewsTrigger.addTriggerListener("myTriggerListener");
		scheduler.addTriggerListener(myTriggerListener);
		/*********全局Trigger监听器配置************/
//		scheduler.addGlobalTriggerListener(myTriggerListener);//直接添加为全局监听器
		/************SchedulerListener配置*************/
		SchedulerListener mySchedulerListener = new MySchedulerListener();
		scheduler.addSchedulerListener(mySchedulerListener);
		
		scheduler.scheduleJob(pickNewsJob,pickNewsTrigger);
		scheduler.scheduleJob(getHottestJob,getHottestTrigger);
		
		scheduler.start();

	}
}
