package tool.job;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.type.YesNoType;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.JobListener;
import org.quartz.Matcher;
import org.quartz.ObjectAlreadyExistsException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SchedulerListener;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.TriggerListener;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.AndMatcher;
import org.quartz.impl.matchers.EverythingMatcher;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.impl.matchers.KeyMatcher;
import org.quartz.impl.matchers.OrMatcher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PickNewsJob implements Job {

	@Override
	public void execute(JobExecutionContext jec) throws JobExecutionException {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.println("在" + sdf.format(new Date()) + "扒取新闻");
	}
	public static void main(String args[]) throws SchedulerException {
		final JobDetail pickNewsJob = JobBuilder.newJob(PickNewsJob.class)
				.withIdentity("job1", "jgroup1").build();
//		GroupMatcher<JobKey> groupMatcher = GroupMatcher.jobGroupContains("group1");
//		GroupMatcher.groupEndsWith("oup1");
//		GroupMatcher.groupEquals("jgroup1");
//		GroupMatcher.groupStartsWith("jgou");
//		EverythingMatcher<JobKey> everythingMatcher = EverythingMatcher.allJobs();
//		EverythingMatcher<JobKey> everythingMatcher = EverythingMatcher.allTriggers()();
//		AndMatcher<JobKey> andMatcher = AndMatcher.and(keyMatcher,groupMatcher);
//		OrMatcher<JobKey> orMatcher = OrMatcher.or(keyMatcher, groupMatcher);
		
		JobDetail getHottestJob = JobBuilder.newJob(GetHottestJob.class)
				.withIdentity("job2", "jgroup2").build();
		SimpleTrigger pickNewsTrigger = TriggerBuilder
				.newTrigger()
				.withIdentity("trigger1","tgroup1")
				.withSchedule(SimpleScheduleBuilder.repeatSecondlyForTotalCount(2, 1)).startNow()
				.build();
		SimpleTrigger getHottestTrigger = TriggerBuilder
				.newTrigger()
				.withIdentity("trigger2","tgroup2")
				.withSchedule(SimpleScheduleBuilder.repeatSecondlyForTotalCount(2, 2)).startNow()
				.build();
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		JobListener myJobListener = new MyJobListener();
		KeyMatcher<JobKey> keyMatcher = KeyMatcher.keyEquals(pickNewsJob.getKey());
		
		TriggerListener myTriggerListener = new MyTriggerListener();
		KeyMatcher<TriggerKey> tkeyMatcher = KeyMatcher.keyEquals(pickNewsTrigger.getKey());
		
		scheduler.getListenerManager().addJobListener(myJobListener, keyMatcher);
		scheduler.getListenerManager().addTriggerListener(myTriggerListener, tkeyMatcher);
		
		SchedulerListener mySchedulerListener = new MySchedulerListener();
		scheduler.getListenerManager().addSchedulerListener(mySchedulerListener);
		scheduler.scheduleJob(pickNewsJob, pickNewsTrigger);
		scheduler.scheduleJob(getHottestJob,getHottestTrigger);
		scheduler.start();
	}
	
	
	/**
	 *根据数据库中的记录 恢复异常中断的任务
	 */
	public static void resumeJob() throws SchedulerException {
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();
		// ①获取调度器中所有的触发器组
		List<String> triggerGroups = scheduler.getTriggerGroupNames();
		// ②重新恢复在tgroup1组中，名为trigger1触发器的运行
		for (int i = 0; i < triggerGroups.size(); i++) {
			List<String> triggers = scheduler.getTriggerGroupNames();
			for (int j = 0; j < triggers.size(); j++) {
				Trigger tg = scheduler.getTrigger(new TriggerKey(triggers
						.get(j), triggerGroups.get(i)));
				// ②-1:根据名称判断
				if (tg instanceof SimpleTrigger
						&& tg.getDescription().equals("jgroup1.DEFAULT")) {//由于我们之前测试没有设置触发器所在组，所以默认为DEFAULT
					// ②-1:恢复运行
					scheduler.resumeJob(new JobKey(triggers.get(j),
							triggerGroups.get(i)));
				}
			}
		}
		scheduler.start();

	}
}
