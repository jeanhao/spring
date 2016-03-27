package tool.job;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SchedulerListener;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerListener;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;
import org.springframework.scheduling.annotation.Scheduled;

public class PickNewsJob implements Job {

	@Override
	public void execute(JobExecutionContext jec) throws JobExecutionException {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.println("在" + sdf.format(new Date()) + "扒取新闻");
	}

}
