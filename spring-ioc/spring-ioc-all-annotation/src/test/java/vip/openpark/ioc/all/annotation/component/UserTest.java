package vip.openpark.ioc.all.annotation.component;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vip.openpark.ioc.all.annotation.config.SpringAnnotationConfig;

/**
 * @author anthony
 * @version 2023/11/15 20:06
 */
@Slf4j
public class UserTest {
    @Test
    public void test() {
        // 加载 spring 配置类的方式
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringAnnotationConfig.class);
        User bean = applicationContext.getBean(User.class);
        log.info("{}", bean);
    }

    @Test
    public void lazyBeanTest(){
        // 加载 spring 配置类的方式
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringAnnotationConfig.class);
        // 实时查找
        User beanByRealTime = applicationContext.getBean(User.class);
        log.info("{}", beanByRealTime);

        // 延迟查找
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) applicationContext.getBean("objectFactoryCreatingFactoryBean");
        User beanByLazy = objectFactory.getObject();
        log.info("{}", beanByLazy);
    }
}