package vip.openpark.aop.xml.auto.proxy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author anthony
 * @since 2024/1/13 22:26
 */
@Slf4j
public class BeanNameAutoProxyBeanTest {
	@Test
	public void beanNameAutoProxyBeanTest() {
		// 加载 spring 配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beanNameAutoProxyBean.xml");
		// 获取创建的对象
		EchoService bean = applicationContext.getBean("echoService", EchoService.class);
		bean.echo("hello");
	}
}