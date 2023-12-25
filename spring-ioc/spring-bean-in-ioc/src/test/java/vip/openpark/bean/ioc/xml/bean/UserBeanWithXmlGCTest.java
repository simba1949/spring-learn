package vip.openpark.bean.ioc.xml.bean;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author anthony
 * @version 2023/12/25 22:19
 */
@Slf4j
public class UserBeanWithXmlGCTest {
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
		log.info("beanDefinitionCount = {}", beanDefinitionCount);

		UserBeanWithXmlGC bean = defaultListableBeanFactory.getBean("userBeanWithXmlGC", UserBeanWithXmlGC.class);
		log.info("bean = {}", bean);

		// 销毁 bean，销毁并不意味着被 GC 回收，只是触发了销毁方法
		defaultListableBeanFactory.destroyBean("userBeanWithXmlGC", bean);
		// 销毁 spring ioc 容器
		defaultListableBeanFactory.destroySingletons();
		// 手动触发 GC
		System.gc();

		try {
			Thread.sleep(10000L);
		} catch (InterruptedException e) {
			log.info("{}", e.getMessage(), e);
		}

		// 手动触发 GC
		System.gc();
	}
}