package test.aop4;

public class MyTask {
	private static ThreadLocal<Long>beginTime = new ThreadLocal<Long>() ;//记录开始时间
	private static ThreadLocal<String> target = new ThreadLocal<String>();//
	
	public static void beginRecord(){
		System.out.println("记时开始");
		beginTime .set(System.currentTimeMillis());
	}
	
	public static void endRecord(){
		System.out.println("记时结束");
		System.out.println("调用"+target+"方法耗时：" +( System.currentTimeMillis()  - beginTime.get())+ "毫秒");
	}

	public static ThreadLocal<String> getTarget() {
		return target;
	}

}
