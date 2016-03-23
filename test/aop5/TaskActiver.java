package test.aop5;


public interface TaskActiver {//通过此接口来监控是是否激活定时器任务
	void startTask();
	void stopTask();
}
