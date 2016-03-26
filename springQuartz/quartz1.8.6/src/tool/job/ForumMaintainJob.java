package tool.job;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ForumMaintainJob implements Job{
	
	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		System.out.println("论坛维护");
	}

}
