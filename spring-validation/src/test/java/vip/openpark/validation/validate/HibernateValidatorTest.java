package vip.openpark.validation.validate;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import vip.openpark.validation.common.UserWithHibernateValidator;
import vip.openpark.validation.controller.UserController;

/**
 * @author anthony
 * @since 2023/12/30 15:33
 */
@Slf4j
public class HibernateValidatorTest {

	/**
	 * 使用 ClassPathXmlApplicationContext 创建 spring ioc 容器，并指定配置文件位置
	 */
	@Test
	public void runSpringIocWithClassPathXmlApplicationContextTest() {
		// 加载 spring 配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
		// 获取 Validator 实例
		Validator validator = applicationContext.getBean(Validator.class);
		// 验证是否使用了 LocalValidatorFactoryBean
		log.info("{}", validator instanceof LocalValidatorFactoryBean);

		// 校验 user
		UserWithHibernateValidator user = new UserWithHibernateValidator();
		user.setId(1L);
		user.setName("");
		UserController userController = applicationContext.getBean(UserController.class);
		userController.insert(user);
	}
}