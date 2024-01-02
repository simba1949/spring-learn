package vip.openpark.annotation;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author anthony
 * @since 2024/1/2 23:34
 */
@Slf4j
@EnableHelloWorld // 这里使用 @EnableHelloWorld 注解，就会在 spring ioc 容器中存在对应配置类中的 bean
public class EnableHelloWorldTest {
	@Test
	public void runTest() {
		// 创建 beanFactory 容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 指定配置类
		applicationContext.register(EnableHelloWorldTest.class);
		// 刷新容器：启动应用上下文
		applicationContext.refresh();
		
		String bean = applicationContext.getBean("helloWorld", String.class);
		log.info("bean={}", bean);
	}
}