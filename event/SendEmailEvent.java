package test.event;

import org.springframework.context.ApplicationEvent;

public class SendEmailEvent extends ApplicationEvent {
	
	private String emailAddress;
	
	public SendEmailEvent(Object  source,String emailAddress ) {
		super(source);
		this.emailAddress = emailAddress;
	}
	
		public String getEmailAddress() {
			return emailAddress;
		}
}
