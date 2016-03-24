package com.proxy.demo2;
//这是我们项目中“历史悠久”的类，功能完整，有很多方法。现在我们需要为每个方法都实现性能统计
public class OldClass {
	public void method1() throws InterruptedException{
		System.out.println("正在处理业务逻辑1");
		Thread.sleep(100);//模拟处理业务逻辑4过程
		System.out.println("业务逻辑1处理完成");
	}
	public void method2() throws InterruptedException{
		System.out.println("正在处理业务逻辑2");
		Thread.sleep(200);//模拟处理业务逻辑2过程
		System.out.println("业务逻辑2处理完成");
	}
	public void method3(String userName) throws InterruptedException{
		System.out.println("正在处理业务逻辑3");
		Thread.sleep(300);//模拟处理业务逻辑3过程
		System.out.println("业务逻辑3处理完成");
	}
	//下面还有很多很多。。
}
