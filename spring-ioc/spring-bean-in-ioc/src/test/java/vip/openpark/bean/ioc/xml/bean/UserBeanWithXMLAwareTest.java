package vip.openpark.bean.ioc.xml.bean;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author anthony
 * @version 2023/12/19 16:00
 */
@Slf4j
public class UserBeanWithXMLAwareTest {
	/**
	 * 使用 ClassPathXmlApplicationContext 创建 spring ioc 容器，并指定配置文件位置
	 */
	@Test
	public void runSpringIocTest() {
		// 加载 spring 配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
		UserBeanWithXMLAware userBeanWithXMLAware = applicationContext.getBean("userBeanWithAware", UserBeanWithXMLAware.class);
		log.info("userBeanWithAware = {}", userBeanWithXMLAware);
	}
}