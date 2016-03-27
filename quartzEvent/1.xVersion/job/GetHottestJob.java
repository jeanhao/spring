package tool.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class GetHottestJob implements Job {

	@Override
	public void execute(JobExecutionContext jec) throws JobExecutionException {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.println("在" + sdf.format(new Date()) +"根据文章的阅读量和评论量来生成我们的最热文章列表");
	}

}
