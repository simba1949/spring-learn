package vip.openpark.bean.ioc.xml.bean;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;

/**
 * @author anthony
 * @version 2023/12/22 17:56
 */
@Slf4j
public class UserBeanWithXmlDisposableBeanTest {
	/**
	 * 1.创建 spring ioc 默认容器 DefaultListableBeanFactory
	 * 2.使用 XmlBeanDefinitionReader 读取 xml 配置文件，解析成 beanDefinition
	 */
	@Test
	public void runSpringIocWithDefaultListableBeanFactoryTest() {
		// 创建 spring ioc 容器，spring ioc 默认 DefaultListableBeanFactory
		DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
		// 解决 {@link jakarta.annotation.PostConstruct} and {@link jakarta.annotation.PreDestroy} 注解问题
		defaultListableBeanFactory.addBeanPostProcessor(new CommonAnnotationBeanPostProcessor());
		
		// 读取使用 XML 配置的 bean
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
		String location = "classpath:bean.xml";
		// 加载 XML 配置，返回配置 bean 的数量
		int beanDefinitionCount = xmlBeanDefinitionReader.loadBeanDefinitions(location);
		log.info("{}", beanDefinitionCount);
		
		UserBeanWithXmlDisposableBean bean = defaultListableBeanFactory.getBean("userBeanWithXmlDisposableBean", UserBeanWithXmlDisposableBean.class);
		log.info("{}", bean);
		
		defaultListableBeanFactory.destroyBean("userBeanWithXmlDisposableBean", bean);
	}
}
