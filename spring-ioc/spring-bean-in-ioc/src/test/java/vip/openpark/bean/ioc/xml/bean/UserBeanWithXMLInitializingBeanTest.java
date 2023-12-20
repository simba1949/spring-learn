package vip.openpark.bean.ioc.xml.bean;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;

/**
 * @author anthony
 * @version 2023/12/20 16:40
 */
@Slf4j
public class UserBeanWithXMLInitializingBeanTest {
	/**
	 * 基于注解的 bean 容器
	 */
	@Test
	public void runSpringIocTest() {
		// 创建 spring ioc 容器，spring ioc 默认 DefaultListableBeanFactory
		DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
		// 注解处理器
		defaultListableBeanFactory.addBeanPostProcessor(new CommonAnnotationBeanPostProcessor());
		
		// 读取使用 XML 配置的 bean
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
		String location = "classpath:bean.xml";
		// 加载 XML 配置，返回配置 bean 的数量
		int beanDefinitionCount = xmlBeanDefinitionReader.loadBeanDefinitions(location);
		log.info("{}", beanDefinitionCount);
		
		UserBeanWithXMLInitializingBean bean = defaultListableBeanFactory.getBean(UserBeanWithXMLInitializingBean.class);
		log.info("bean:{}", bean);
	}
}