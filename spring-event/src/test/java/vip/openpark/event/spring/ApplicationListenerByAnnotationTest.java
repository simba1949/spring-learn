package vip.openpark.event.spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vip.openpark.event.config.SpringAnnotationConfig;

/**
 * @author anthony
 * @since 2024/1/1 9:36
 */
@Slf4j
public class ApplicationListenerByAnnotationTest {
	
	@Test
	public void eventTest() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 指定配置类
		applicationContext.register(SpringAnnotationConfig.class);
		
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