package vip.openpark.bean.ioc.annotation.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author anthony
 * @version 2023/12/29 15:29
 */
@Slf4j
public class PropertySourceConfigTest {
	/**
	 * 基于注解的 bean 容器
	 */
	@Test
	public void runSpringIocWithClassPathXmlApplicationContextTest() {
		// 创建 beanFactory 容器
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		// 指定配置类
		annotationConfigApplicationContext.register(PropertySourceConfig.class);
		// 刷新容器：启动应用上下文
		annotationConfigApplicationContext.refresh();
		
		PropertySourceConfig bean = annotationConfigApplicationContext.getBean(PropertySourceConfig.class);
		log.info("{}", bean);
	}
}