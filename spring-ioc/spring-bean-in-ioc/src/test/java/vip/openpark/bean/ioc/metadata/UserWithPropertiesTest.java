package vip.openpark.bean.ioc.metadata;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;

/**
 * @author anthony
 * @version 2023/12/28 16:19
 */
@Slf4j
public class UserWithPropertiesTest {
	/**
	 * 1.创建 spring ioc 默认容器 DefaultListableBeanFactory
	 * 2.使用 PropertiesBeanDefinitionReader 读取 xml 配置文件，解析成 beanDefinition
	 */
	@Test
	public void runSpringIocWithDefaultListableBeanFactoryTest() {
		// 创建 spring ioc 容器，spring ioc 默认 DefaultListableBeanFactory
		DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
		
		// 读取使用 Properties 配置的 bean
		PropertiesBeanDefinitionReader propertiesBeanDefinitionReader = new PropertiesBeanDefinitionReader(defaultListableBeanFactory);
		String location = "META-INF/user-properties.properties";
		
		// 加载 XML 配置，返回配置 bean 的数量
		int beanDefinitionCount = propertiesBeanDefinitionReader.loadBeanDefinitions(location);
		log.info("{}", beanDefinitionCount);
		
		UserWithProperties bean = defaultListableBeanFactory.getBean("userWithProperties", UserWithProperties.class);
		log.info("bean = {}", bean);
	}
}