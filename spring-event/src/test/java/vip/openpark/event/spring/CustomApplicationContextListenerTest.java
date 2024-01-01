package vip.openpark.event.spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vip.openpark.event.config.SpringAnnotationConfig;

/**
 * @author anthony
 * @since 2024/1/1 10:32
 */
@Slf4j
public class CustomApplicationContextListenerTest {
	@Test
	public void eventTest() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 指定配置类
		applicationContext.register(SpringAnnotationConfig.class);
		
		// 注册自定义的监听器
		applicationContext.addApplicationListener(new CustomApplicationContextListener());
		
		// 启动应用上下文
		applicationContext.refresh(); // ContextRefreshedEvent
	}
}