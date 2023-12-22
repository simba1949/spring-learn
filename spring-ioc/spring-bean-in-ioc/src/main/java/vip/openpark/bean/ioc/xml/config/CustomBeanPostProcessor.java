package vip.openpark.bean.ioc.xml.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import vip.openpark.bean.ioc.xml.bean.UserBeanWithXMLBeanPostProcessor;

/**
 * @author anthony
 * @version 2023/12/19 16:29
 */
public class CustomBeanPostProcessor implements BeanPostProcessor {
	/**
	 * 前置处理
	 *
	 * @param bean     要处理的bean对象
	 * @param beanName bean的名称
	 * @return 理后的bean对象
	 * @throws BeansException 当处理bean对象时抛出异常
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// 【生产慎用】这里做一个特殊处理，对属性重新赋值
		if ("userBeanPostProcessor".equals(beanName) && bean instanceof UserBeanWithXMLBeanPostProcessor) {
			((UserBeanWithXMLBeanPostProcessor) bean).setDescription("spring bean 实例化前设置");
		}
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}
	
	/**
	 * 后置处理
	 *
	 * @param bean     要处理的bean对象
	 * @param beanName bean的名称
	 * @return 处理后的bean对象
	 * @throws BeansException 当处理bean对象时抛出异常
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// 【生产慎用】这里做一个特殊处理，对属性重新赋值
		if ("userBeanPostProcessor".equals(beanName) && bean instanceof UserBeanWithXMLBeanPostProcessor) {
			((UserBeanWithXMLBeanPostProcessor) bean).setName("spring bean 实例化后设置");
		}
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
}