package test.event;

import org.springframework.context.ApplicationEvent;

public class sendMessageEvent extends ApplicationEvent {
	
	private String phoneNum;
	
	public sendMessageEvent(Object  source,String phoneNum ) {
		super(source);
		this.phoneNum = phoneNum;
	}

	public String getPhoneNum() {
		return phoneNum;
	}
}
