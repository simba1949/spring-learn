package vip.openpark.bean.ioc.xml.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import vip.openpark.bean.ioc.xml.bean.UserBeanWithXmlDestructionAwareBeanPostProcessor;

/**
 * @author anthony
 * @version 2023/12/22 17:29
 */
@Slf4j
public class CustomDestructionAwareBeanPostProcessor implements DestructionAwareBeanPostProcessor {
	/**
	 * Post-process the bean instance before it is destroyed.
	 *
	 * @param bean     the bean instance to be destroyed
	 * @param beanName the name of the bean
	 * @throws BeansException if bean instance processing failed
	 */
	@Override
	public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
		if ("userBeanWithXmlDestructionAwareBeanPostProcessor".equals(beanName) &&
			    bean instanceof UserBeanWithXmlDestructionAwareBeanPostProcessor) {
			log.info("CustomDestructionAwareBeanPostProcessor postProcessBeforeDestruction");
		}
	}
}
