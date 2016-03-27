package tool.job;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;

public class MyTriggerListener implements TriggerListener {

	@Override
	public String getName() {
		return "myTriggerListener";
	}

	@Override
	public void triggerFired(Trigger trigger, JobExecutionContext context) {
		System.out.println(" Trigger 被触发了，此时Job 上的 execute() 方法将要被执行");
	}

	@Override
	public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
//		System.out.println("发现此次Job的相关资源准备存在问题，不便展开任务，返回true表示否决此次任务执行");
//		return true;
		System.out.println("不否决Job,正常执行");
		return false;
	}

	@Override
	public void triggerMisfired(Trigger trigger) {
		System.out.println( "当前Trigger触发错过了");
	}

	@Override
	public void triggerComplete(Trigger trigger, JobExecutionContext context,
			int triggerInstructionCode) {
		System.out.println("Trigger 被触发并且完成了 Job 的执行,此方法被调用");
	}


}
