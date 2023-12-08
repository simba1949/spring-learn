package vip.openpark.ioc.all.annotation.custom;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vip.openpark.ioc.all.annotation.config.SpringAnnotationConfig;

/**
 * @author anthony
 * @version 2023/12/8 18:02
 */
@Slf4j
public class AllCustomAutowiredContainerTest {
	@Test
	public void test() {
		// 加载 spring 配置类的方式
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringAnnotationConfig.class);
		AllCustomAutowiredContainer bean0 = applicationContext.getBean(AllCustomAutowiredContainer.class);
		log.info("{}", bean0.getUser());

		CustomComponentContainer bean1 = applicationContext.getBean(CustomComponentContainer.class);
		log.info("{}", bean1.getUser());

		Assertions.assertSame(bean0.getUser(), bean1.getUser());
	}
}