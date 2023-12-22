package vip.openpark.bean.ioc.xml.bean;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import vip.openpark.bean.ioc.xml.config.CustomDestructionAwareBeanPostProcessor;

/**
 * @author anthony
 * @version 2023/12/22 17:14
 */
@Slf4j
public class UserBeanWithXmlDestructionAwareBeanPostProcessorTest {
	/**
	 * 1.创建 spring ioc 默认容器 DefaultListableBeanFactory
	 * 2.使用 XmlBeanDefinitionReader 读取 xml 配置文件，解析成 beanDefinition
	 */
	@Test
	public void runSpringIocWithDefaultListableBeanFactoryTest() {
		// 创建 spring ioc 容器，spring ioc 默认 DefaultListableBeanFactory
		DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
		defaultListableBeanFactory.addBeanPostProcessor(new CustomDestructionAwareBeanPostProcessor());
		
		// 读取使用 XML 配置的 bean
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
		String location = "classpath:bean.xml";
		// 加载 XML 配置，返回配置 bean 的数量
		int beanDefinitionCount = xmlBeanDefinitionReader.loadBeanDefinitions(location);
		log.info("{}", beanDefinitionCount);
		
		UserBeanWithXmlDestructionAwareBeanPostProcessor bean = defaultListableBeanFactory.getBean("userBeanWithXmlDestructionAwareBeanPostProcessor", UserBeanWithXmlDestructionAwareBeanPostProcessor.class);
		log.info("bean = {}", bean);
		
		// bean 的销毁，并不意味着被 GC
		// 这里需要指定bean的名称和对应的bean
		defaultListableBeanFactory.destroyBean("userBeanWithXmlDestructionAwareBeanPostProcessor", bean);
	}
}
