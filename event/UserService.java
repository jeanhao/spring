package test.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class UserService implements ApplicationEventPublisherAware {

	private ApplicationEventPublisher applicationEventPublisher;//底层事件发布者
	
	@Override
	public void setApplicationEventPublisher(//通过Set方法完成我们的实际发布者注入
			ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}
	
	public void doLogin(String emailAddress,String phoneNum) throws InterruptedException{
		Thread.sleep(200);//模拟用户注册的相关业务逻辑处理
		System.out.println("注册成功！");
		//下列向用户发送邮件
		SendEmailEvent sendEmailEvent = new SendEmailEvent(this,emailAddress);//定义事件
		sendMessageEvent sendMessageEvent = new sendMessageEvent(this, phoneNum);
		applicationEventPublisher.publishEvent(sendEmailEvent);//发布事件
		applicationEventPublisher.publishEvent(sendMessageEvent);
	}

}
