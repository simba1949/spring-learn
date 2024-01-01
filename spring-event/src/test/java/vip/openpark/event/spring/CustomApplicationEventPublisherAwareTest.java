package vip.openpark.event.spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vip.openpark.event.config.SpringAnnotationConfig;

/**
 * @author anthony
 * @since 2024/1/1 10:46
 */
@Slf4j
public class CustomApplicationEventPublisherAwareTest {
	@Test
	public void eventTest() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 指定配置类
		applicationContext.register(SpringAnnotationConfig.class);
		
		// 启动应用上下文
		applicationContext.refresh(); // ContextRefreshedEvent
		
		CustomApplicationEventPublisherAware eventPublisherAware = applicationContext.getBean(CustomApplicationEventPublisherAware.class);
		// 获取事件发布器
		ApplicationEventPublisher applicationEventPublisher = eventPublisherAware.getApplicationEventPublisher();
		// 发布事件
		// 这里发送的是 ApplicationEvent
		applicationEventPublisher.publishEvent(new ApplicationEvent("Hello World!") {
		});
		// 这里发送的是 PayloadApplicationEvent
		applicationEventPublisher.publishEvent("Hello World!");
	}
}
