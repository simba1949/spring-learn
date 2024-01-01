package vip.openpark.event.spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author anthony
 * @since 2024/1/1 11:36
 */
@Slf4j
public class CustomSpringEventTest {
	
	@Test
	public void eventTest() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 注册监听器
		applicationContext.register(CustomSpringEventListener.class);
		
		// 启动应用上下文
		applicationContext.refresh(); // ContextRefreshedEvent
		
		// 发布事件（这里 this 表示事件发布源）
		CustomSpringEvent customSpringEvent = new CustomSpringEvent(this);
		customSpringEvent.setPayload("Hello World!");
		applicationContext.publishEvent(customSpringEvent);
	}
}