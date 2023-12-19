package vip.openpark.bean.ioc.xml.bean.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.util.ObjectUtils;
import vip.openpark.bean.ioc.xml.bean.BookBeanWithXMLInstantiationProcessor;

/**
 * @author anthony
 * @version 2023/12/19 14:33
 */
public class SpringBeanInstantiationProcessor implements InstantiationAwareBeanPostProcessor {
	
	/**
	 * 在实例化之前进行后处理器操作
	 *
	 * @param beanClass 需要实例化的类
	 * @param beanName  需要实例化的 bean 的名称
	 * @return 返回处理后的对象
	 * @throws BeansException 抛出BeansException异常
	 */
	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		if (ObjectUtils.nullSafeEquals("bookBeanWithInstantiationProcessor", beanName) &&
			    BookBeanWithXMLInstantiationProcessor.class.equals(beanClass)) {
			// 把配置完成 BookBeanWithInstantiationProcessor Bean 覆盖
			return new BookBeanWithXMLInstantiationProcessor();
		}
		// 保持 spring ioc 容器的实例化操作
		return null;
	}
	
	/**
	 * 在对象实例化后进行后处理操作
	 *
	 * @param bean     实例化的对象
	 * @param beanName 实例化的对象的名称
	 * @return 布尔值，表示是否继续执行后续的bean后处理操作
	 * @throws BeansException Bean后处理异常
	 */
	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		// 【生产慎用】这里做一个特殊处理，不允许属性赋值
		if (ObjectUtils.nullSafeEquals("bookBeanWithInstantiationProcessor", beanName) &&
			    BookBeanWithXMLInstantiationProcessor.class.equals(bean.getClass())) {
			// "bookBeanWithInstantiationProcessor" 对象不允许属性赋值（配置元信息——>属性值）
			return false;
		}
		return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
	}
}