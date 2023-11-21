package vip.openpark.ioc.all.annotation;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vip.openpark.ioc.all.annotation.component.User;
import vip.openpark.ioc.all.annotation.config.SpringAnnotationConfig;

/**
 * @author anthony
 * @version 2023/11/21 23:41
 */
@Slf4j
public class ApplicationContextAsIocContainerTest {

    @Test
    public void execTest(){
        // 创建 beanFactory 容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        // 指定配置类
        annotationConfigApplicationContext.register(SpringAnnotationConfig.class);
        // 刷新容器：启动应用上下文
        annotationConfigApplicationContext.refresh();

        User bean = annotationConfigApplicationContext.getBean(User.class);
        log.info("{}", bean);
    }
}