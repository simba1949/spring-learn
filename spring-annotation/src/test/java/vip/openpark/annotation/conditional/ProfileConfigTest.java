package vip.openpark.annotation.conditional;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author anthony
 * @version 2024/1/3 12:35
 */
@Slf4j
public class ProfileConfigTest {
	@Test
	public void runTest() {
		// 创建 beanFactory 容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 指定配置类
		applicationContext.register(ProfileConfig.class);
		
		// 通过上下文获取 Environment，用于设置激活的环境
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		// 第一种方式：设置默认的环境
		environment.setDefaultProfiles("odd");
		// 第二种方式：设置激活的环境（激活有限）
		environment.setActiveProfiles("odd");
		
		// 刷新容器：启动应用上下文
		applicationContext.refresh();
		
		Integer bean = applicationContext.getBean("number", Integer.class);
		log.info("bean={}", bean);
	}
}
