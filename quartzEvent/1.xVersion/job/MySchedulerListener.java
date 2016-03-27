package tool.job;

import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.SchedulerListener;
import org.quartz.Trigger;

public class MySchedulerListener implements SchedulerListener {

	@Override
	public void jobScheduled(Trigger trigger) {
		System.out.println("任务被部署时被执行");
	}


	@Override
	public void triggerFinalized(Trigger trigger) {
		System.out.println("任务完成时被执行它的使命，光荣退休时被执行");
	}

	@Override
	public void jobAdded(JobDetail jobDetail) {
		System.out.println("一个新的任务被动态添加时执行");
	}



	@Override
	public void jobUnscheduled(String triggerName, String triggerGroup) {
		System.out.println("任务被卸载时被执行");
		
	}

	@Override
	public void triggersPaused(String triggerName, String triggerGroup) {
		System.out.println(triggerGroup + "所在组的全部触发器被停止时被执行");
	}

	@Override
	public void triggersResumed(String triggerName, String triggerGroup) {
		System.out.println(triggerGroup + "所在组的全部触发器被回复时被执行");
	}

	@Override
	public void jobDeleted(String jobName, String groupName) {
		System.out.println(groupName + "." + jobName + "被删除时被执行");
	}

	@Override
	public void jobsPaused(String jobName, String jobGroup) {
		System.out.println(jobGroup + "(一组任务）被暂停时被执行");
	}

	@Override
	public void jobsResumed(String jobName, String jobGroup) {
		System.out.println(jobGroup + "(一组任务）被回复时被执行");
	}
	@Override
	public void schedulerError(String msg, SchedulerException cause) {
		System.out.println("出现异常" + msg + "时被执行");
		cause.printStackTrace();
	}

	@Override
	public void schedulerInStandbyMode() {
		System.out.println("scheduler被设为standBy等候模式时被执行");
		
	}

	@Override
	public void schedulerStarted() {
		System.out.println("scheduler启动时被执行");
		
	}

	@Override
	public void schedulerShutdown() {
		System.out.println("scheduler关闭时被执行");
	}

	@Override
	public void schedulerShuttingdown() {
		System.out.println("scheduler正在关闭时被执行");
	}
}
