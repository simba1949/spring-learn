package vip.openpark.bean.ioc.metadata;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author anthony
 * @version 2023/12/28 10:37
 */
@Slf4j
public class UserWithMetadataTest {
	/**
	 * 1.创建 spring ioc 默认容器 DefaultListableBeanFactory
	 * 2.使用 XmlBeanDefinitionReader 读取 xml 配置文件，解析成 beanDefinition
	 */
	@Test
	public void runSpringIocWithDefaultListableBeanFactoryTest() {
		// 创建 beanDefinition
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserWithMetadata.class);
		beanDefinitionBuilder.addPropertyValue("name", "anthony");
		// 获取 beanDefinition
		AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
		// 附加属性（不影响 bean 的实例化、初始化、赋值）
		beanDefinition.setAttribute("id", 1L);
		// 设置 bean 的来源
		beanDefinition.setSource(UserWithMetadataTest.class);
		
		// 创建 spring ioc 容器，spring ioc 默认 DefaultListableBeanFactory
		DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
		// 添加 beanPostProcessor，利用 spring bean 生命周期将附加属性赋值给 bean
		defaultListableBeanFactory.addBeanPostProcessor(new BeanPostProcessor() {
			@Override
			public Object postProcessBeforeInitialization(Object bean, String beanName) {
				log.info("beanName = {}, bean = {}", beanName, bean);
				if (bean instanceof UserWithMetadata && "userWithMetadata".equals(beanName)) {
					BeanDefinition beanDefinition4Val = defaultListableBeanFactory.getBeanDefinition("userWithMetadata");
					// 获取 bean 的来源
					Object source = beanDefinition4Val.getSource();
					if (null != source) {
						log.info("beanDefinition4Val.getSource() = {}", source);
					}
					
					// 获取附加属性
					Object id = beanDefinition4Val.getAttribute("id");
					if (null != id) {
						UserWithMetadata userWithMetadata = (UserWithMetadata) bean;
						userWithMetadata.setId((Long) id);
					}
				}
				return bean;
			}
		});
		// 注册 beanDefinition
		defaultListableBeanFactory.registerBeanDefinition("userWithMetadata", beanDefinition);
		
		// 获取 bean
		UserWithMetadata bean = defaultListableBeanFactory.getBean("userWithMetadata", UserWithMetadata.class);
		log.info("bean = {}", bean);
	}
}