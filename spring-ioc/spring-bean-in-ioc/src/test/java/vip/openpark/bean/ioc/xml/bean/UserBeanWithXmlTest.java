package vip.openpark.bean.ioc.xml.bean;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author anthony
 * @version 2023/12/18 16:41
 */
@Slf4j
public class UserBeanWithXmlTest {
	/**
	 * 1.创建 spring ioc 默认容器 DefaultListableBeanFactory
	 * 2.使用 XmlBeanDefinitionReader 读取 xml 配置文件，解析成 beanDefinition
	 */
	@Test
	public void runSpringIocWithDefaultListableBeanFactoryTest() {
		// 创建 spring ioc 容器，spring ioc 默认 DefaultListableBeanFactory
		DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
		// 读取使用 XML 配置的 bean
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
		String location = "classpath:bean.xml";
		// 加载 XML 配置，返回配置 bean 的数量
		int beanDefinitionCount = xmlBeanDefinitionReader.loadBeanDefinitions(location);
		log.info("{}", beanDefinitionCount);

		UserBeanWithXml bean = defaultListableBeanFactory.getBean("userBeanWithXml", UserBeanWithXml.class);
		log.info("bean = {}", bean);
	}

	/**
	 * 使用 ClassPathXmlApplicationContext 创建 spring ioc 容器，并指定配置文件位置
	 */
	@Test
	public void runSpringIocWithClassPathXmlApplicationContextTest() {
		// 加载 spring 配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
		UserBeanWithXml bean = applicationContext.getBean("userBeanWithXml", UserBeanWithXml.class);
		log.info("bean = {}", bean);
	}
}