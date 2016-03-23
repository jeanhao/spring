package test.aop4;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class MyTaskController extends DelegatingIntroductionInterceptor implements TaskActiver{
	private ThreadLocal<Boolean> isTime = new ThreadLocal<Boolean>();

	public MyTaskController(){
		isTime.set(false);
	}
	@Override
	public void startTask() {//通过定时器监控达到特定时间，启动任务。
		isTime.set(true);
	}

	@Override
	public void stopTask() {//在任务完成后关闭任务，等待下次定时器到时启动
		isTime.set(false);
	}
	
	/**
	 * //覆盖父类的invoke方法，当程序运行到特定方法时，我们先拦截下来，
	 * 然后启动我们的任务，再调用相应的方法，在方法调用完后，完成并关闭我们的任务

	 */
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable{
		Object obj = null;
		if(isTime.get()){//到了特定时刻
			MyTask.getTarget().set(invocation.getMethod().getName());
			MyTask.beginRecord();
			obj = super.invoke(invocation);
			MyTask.endRecord();
//			stopTask();
		}else{
			obj = super.invoke(invocation);
		}
		return obj;
	}
	
}
