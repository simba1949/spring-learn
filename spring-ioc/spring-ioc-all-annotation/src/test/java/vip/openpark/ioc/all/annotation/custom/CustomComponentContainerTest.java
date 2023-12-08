package vip.openpark.ioc.all.annotation.custom;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vip.openpark.ioc.all.annotation.config.SpringAnnotationConfig;

/**
 * @author anthony
 * @version 2023/12/8 17:46
 */
@Slf4j
public class CustomComponentContainerTest {

	@Test
	public void test() {
		// 加载 spring 配置类的方式
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringAnnotationConfig.class);
		CustomComponentContainer bean = applicationContext.getBean(CustomComponentContainer.class);
		log.info("{}", bean.getUser());
	}
}