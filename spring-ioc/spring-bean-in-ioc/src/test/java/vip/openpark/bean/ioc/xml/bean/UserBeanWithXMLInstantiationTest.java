package vip.openpark.bean.ioc.xml.bean;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author anthony
 * @version 2024/1/15 15:12
 */
@Slf4j
public class UserBeanWithXMLInstantiationTest {
	
	@Test
	public void beanInstantiationWithXmlFactoryMethod() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-instantiation .xml");
		UserBeanWithXMLInstantiation bean1 = applicationContext.getBean("userBeanWithXMLInstantiation", UserBeanWithXMLInstantiation.class);
		UserBeanWithXMLInstantiation bean2 = applicationContext.getBean("userBeanWithXMLInstantiation", UserBeanWithXMLInstantiation.class);
		// 这里通过指定静态方法创建的bean，即使配置成 scope="prototype"，每次创建的bean都是同一个对象
		// bean1 == bean2 : true
		log.info("bean1 == bean2 : {}", bean1 == bean2);
	}
}