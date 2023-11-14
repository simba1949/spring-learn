package vip.openpark.ioc.xml.factorybean;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author anthony
 * @version 2023/11/14 20:44
 */
@Slf4j
public class CustomFactoryBeanTest {
    @Test
    public void beanLifeCycleTest() {
        // 加载 spring 配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("factory-bean.xml");
        // 获取创建的对象
        User user = applicationContext.getBean("user", User.class);
        log.info("{}", user);
    }
}