package vip.openpark.ioc.annotation.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author anthony
 * @version 2023/11/14 21:46
 */
@Slf4j
public class UserControllerTest {
    @Test
    public void test() {
        // 加载 spring 配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        UserController bean = applicationContext.getBean(UserController.class);
        log.info("{}", bean);
    }
}