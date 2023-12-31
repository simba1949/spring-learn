package vip.openpark.type.conversion;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vip.openpark.type.conversion.common.User;

/**
 * @author anthony
 * @since 2023/12/31 10:10
 */
@Slf4j
public class CustomPropertyEditorRegistrarTest {
	/**
	 * 使用 ClassPathXmlApplicationContext 创建 spring ioc 容器，并指定配置文件位置
	 */
	@Test
	public void runSpringIocWithClassPathXmlApplicationContextTest() {
		// 加载 spring 配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
		
		User bean = applicationContext.getBean("user", User.class);
		log.info("bean = {}", bean);
	}
}