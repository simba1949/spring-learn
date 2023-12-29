package vip.openpark.bean.ioc.annotation.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vip.openpark.bean.ioc.annotation.bean.UserWithImportResource;
import vip.openpark.bean.ioc.annotation.config.UserWithImportResourceConfig;

/**
 * @author anthony
 * @version 2023/12/29 13:52
 */
@Slf4j
public class UserWithImportResourceConfigTest {
	/**
	 * 基于注解的 bean 容器
	 */
	@Test
	public void runSpringIocWithClassPathXmlApplicationContextTest() {
		// 创建 beanFactory 容器
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		// 指定配置类
		annotationConfigApplicationContext.register(UserWithImportResourceConfig.class);
		// 刷新容器：启动应用上下文
		annotationConfigApplicationContext.refresh();
		
		UserWithImportResource bean = annotationConfigApplicationContext.getBean(UserWithImportResource.class);
		log.info("{}", bean);
	}
}
