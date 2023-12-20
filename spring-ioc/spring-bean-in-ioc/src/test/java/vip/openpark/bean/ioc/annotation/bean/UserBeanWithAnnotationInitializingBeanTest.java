package vip.openpark.bean.ioc.annotation.bean;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vip.openpark.bean.ioc.annotation.config.SpringAnnotationConfig;

/**
 * @author anthony
 * @version 2023/12/20 17:02
 */
@Slf4j
public class UserBeanWithAnnotationInitializingBeanTest {
	/**
	 * 基于注解的 bean 容器
	 */
	@Test
	public void runSpringIocWithClassPathXmlApplicationContextTest() {
		// 创建 beanFactory 容器
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		// 指定配置类
		annotationConfigApplicationContext.register(SpringAnnotationConfig.class);
		// 刷新容器：启动应用上下文
		annotationConfigApplicationContext.refresh();
		
		UserBeanWithAnnotationInitializingBean bean = annotationConfigApplicationContext.getBean(UserBeanWithAnnotationInitializingBean.class);
		log.info("{}", bean);
	}
}
