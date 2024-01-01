package vip.openpark.event.spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author anthony
 * @since 2024/1/1 9:23
 */
@Slf4j
public class ApplicationListenerByApiTest {
	
	@Test
	public void onEventTest() {
		GenericApplicationContext applicationContext = new GenericApplicationContext();
		// 面向 Spring 接口的事件监听
		// 基于 ConfigurableApplicationContext API 实现监听器的注册
		applicationContext.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
			@Override
			public void onApplicationEvent(ApplicationEvent event) {
				log.info("API方式：接收到 spring 事件：{}", event);
			}
		});
		
		// 启动应用上下文
		applicationContext.refresh(); // ContextRefreshedEvent
		// 启动 spring 应用上下文
		applicationContext.start(); // ContextStartedEvent
		// 将实现 Lifecycle 的 component 组件 stop，还可以重新 start 将其重新启动
		applicationContext.stop(); // ContextStoppedEvent
		// 关闭 spring 应用上下文
		applicationContext.close(); // ContextClosedEvent
	}
}