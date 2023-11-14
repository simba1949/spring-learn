package vip.openpark.ioc.annotation.component;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author anthony
 * @version 2023/11/14 21:44
 */
@Slf4j
public class UserComponentTest {
    @Test
    public void test() {
        // 加载 spring 配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        UserComponent bean = applicationContext.getBean(UserComponent.class);
        log.info("{}", bean);
    }
}