package vip.openpark.spring.el.component;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vip.openpark.spring.el.config.SpringAnnotationConfig;

/**
 * @author anthony
 * @version 2024-11-20
 * @since 2024-11-20 14:12
 */
@Slf4j
public class SystemPropertiesComponentTest {

	@Test
	public void systemPropertiesTest() {
		// 创建 beanFactory 容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 指定配置类
		applicationContext.register(SpringAnnotationConfig.class);
		// 刷新容器：启动应用上下文
		applicationContext.refresh();

		SystemPropertiesComponent bean = applicationContext.getBean(SystemPropertiesComponent.class);
		log.info("{}", bean);
	}
}