package test.aop6;


public class MyTaskController  implements TaskActiver{
	private ThreadLocal<Boolean> isTime = new ThreadLocal<Boolean>();

	public MyTaskController(){
		isTime.set(false);
	}
	@Override
	public void startTask() {//通过定时器监控达到特定时间，启动任务。
		System.out.println("任务开启");
		isTime.set(true);
	}

	@Override
	public void stopTask() {//在任务完成后关闭任务，等待下次定时器到时启动
		System.out.println("任务关闭");
		isTime.set(false);
	}
	
}
