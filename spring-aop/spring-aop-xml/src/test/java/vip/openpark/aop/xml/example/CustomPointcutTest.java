package vip.openpark.aop.xml.example;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author anthony
 * @version 2023/11/16 7:45
 */
@Slf4j
public class CustomPointcutTest {
    @Test
    public void test() {
        // 加载 spring 配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("custom-pointcut.xml");
        // 获取创建的对象
        Calculator bean = applicationContext.getBean(Calculator.class);
        log.info("{}", bean.div(1, 1));
    }
}