package vip.openpark.aop.annotation.event.theory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.lang.NonNull;

/**
 * @author anthony
 * @since 2024/1/21 10:12
 */
@Slf4j
public class ShowCallManualExecutor implements ApplicationEventPublisherAware {
	private ApplicationEventPublisher applicationEventPublisher;
	
	public void execute() {
		log.info("execute");
		
		// 执行完成上面内容，手工发送事件
		if (applicationEventPublisher != null) {
			ShowCallEvent<String> event = new ShowCallEvent<>(this);
			event.setPayload("【这是一个手工事件】");
			applicationEventPublisher.publishEvent(event);
		}
	}
	
	@Override
	public void setApplicationEventPublisher(@NonNull ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}
}