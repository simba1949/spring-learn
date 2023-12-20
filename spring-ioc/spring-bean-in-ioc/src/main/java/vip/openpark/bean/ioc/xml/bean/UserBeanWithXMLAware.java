package vip.openpark.bean.ioc.xml.bean;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringValueResolver;

/**
 * {@link org.springframework.beans.factory.Aware}
 *
 * @author anthony
 * @version 2023/12/19 15:40
 */
@Data
public class UserBeanWithXMLAware implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware,
	                                             EnvironmentAware, EmbeddedValueResolverAware, ResourceLoaderAware,
	                                             ApplicationEventPublisherAware, MessageSourceAware, ApplicationContextAware {
	private Long id;
	private String name;
	private Short age;
	
	
	private String beanName;
	private ClassLoader classLoader;
	private BeanFactory beanFactory;
	private Environment environment;
	private StringValueResolver resolver;
	private ResourceLoader resourceLoader;
	private ApplicationEventPublisher applicationEventPublisher;
	private MessageSource messageSource;
	private ApplicationContext applicationContext;
	
	/**
	 * 执行顺序：1
	 * see {@link BeanNameAware}
	 *
	 * @param name the bean name
	 */
	@Override
	public void setBeanName(String name) {
		this.beanName = name;
	}
	
	/**
	 * 执行顺序：2
	 * see {@link BeanNameAware}
	 *
	 * @param classLoader the owning class loader
	 */
	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}
	
	/**
	 * 执行顺序：3
	 * see {@link BeanFactoryAware}
	 *
	 * @param beanFactory the bean factory
	 * @throws BeansException the beans exception
	 */
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}
	
	/**
	 * 执行顺序：4
	 * see {@link EnvironmentAware}
	 *
	 * @param environment the environment
	 */
	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
	
	/**
	 * 执行顺序：5
	 * see {@link EmbeddedValueResolverAware}
	 *
	 * @param resolver the embedded value resolver
	 */
	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		this.resolver = resolver;
	}
	
	/**
	 * 执行顺序：6
	 * see {@link ResourceLoaderAware}
	 *
	 * @param resourceLoader the resource loader
	 */
	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
	
	/**
	 * 执行顺序：7
	 * see {@link ApplicationEventPublisherAware}
	 *
	 * @param applicationEventPublisher the application event publisher
	 */
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}
	
	/**
	 * 执行顺序：8
	 * see {@link MessageSourceAware}
	 *
	 * @param messageSource the message source
	 */
	@Override
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	
	/**
	 * 执行顺序：9
	 * see {@link ApplicationContextAware}
	 *
	 * @param applicationContext the application context
	 * @throws BeansException the beans exception
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}