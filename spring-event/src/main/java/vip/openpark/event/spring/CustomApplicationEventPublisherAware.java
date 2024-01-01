package vip.openpark.event.spring;

import lombok.Getter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * 实现 {@link ApplicationEventPublisherAware} 接口，
 * 在 Spring 容器启动时，会自动注入 ApplicationEventPublisher 对象
 *
 * @author anthony
 * @since 2024/1/1 10:44
 */
@Getter
@Component
public class CustomApplicationEventPublisherAware implements ApplicationEventPublisherAware {
	private ApplicationEventPublisher applicationEventPublisher;
	
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}
}