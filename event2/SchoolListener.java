package test.event2;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
public class SchoolListener implements  SmartApplicationListener  {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("获取当前的申报状态为："+((AuditEvent)event).getStatus() + "——" + ((AuditEvent)event).getAdvice());
		((AuditEvent)event).setStatus(true);
		((AuditEvent)event).setAdvice("学校审核意见：有创意，非常棒！");
	}

	@Override
	public int getOrder() {
		return 1;
	}

	@Override
	public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
		return eventType == AuditEvent.class;
	}

	@Override
	public boolean supportsSourceType(Class<?> sourceType) {
		return sourceType == XiaoBai.class;
	}
}
