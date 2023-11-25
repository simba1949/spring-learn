package vip.openpark.ioc.xml.factorybean;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author anthony
 * @version 2023/11/25 15:14
 */
@Slf4j
public class CustomFactoryBeanInterfaceTest {
    @Test
    public void execTest() {
        // 加载 spring 配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("factory-bean-interface.xml");
        // 获取创建的对象
        User user = applicationContext.getBean("userInterface", User.class);
        log.info("{}", user);
    }
}