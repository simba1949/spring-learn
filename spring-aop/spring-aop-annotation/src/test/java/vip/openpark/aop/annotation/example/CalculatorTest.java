package vip.openpark.aop.annotation.example;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vip.openpark.aop.annotation.config.AspectConfig;

/**
 * @author anthony
 * @version 2023/11/15 22:38
 */
@Slf4j
public class CalculatorTest {
    @Test
    public void test() {
        // 加载 spring 配置类的方式
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AspectConfig.class);
        Calculator bean = applicationContext.getBean(Calculator.class);
        log.info("计算结果：{}", bean.div(1, 1));
    }
}