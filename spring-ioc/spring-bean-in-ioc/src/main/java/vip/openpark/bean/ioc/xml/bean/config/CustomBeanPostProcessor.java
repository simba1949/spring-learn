package vip.openpark.bean.ioc.xml.bean.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

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
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
}