package vip.openpark.ioc.annotation.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author anthony
 * @version 2023/11/14 21:47
 */
@Slf4j
public class UserServiceTest {
    @Test
    public void test() {
        // 加载 spring 配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        UserService bean = applicationContext.getBean(UserService.class);
        log.info("{}", bean);
    }
}