package vip.openpark.ioc.all.annotation.component;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vip.openpark.ioc.all.annotation.config.SpringConfig;

/**
 * @author anthony
 * @version 2023/11/15 20:06
 */
@Slf4j
public class UserTest {
    @Test
    public void test() {
        // 加载 spring 配置类的方式
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        User bean = applicationContext.getBean(User.class);
        log.info("{}", bean);
    }
}