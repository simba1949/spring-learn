package vip.openpark.ioc.all.annotation;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author anthony
 * @version 2023/11/26 5:11
 */
@Slf4j
public class HierarchicalBeanFactoryTest {
    @Test
    public void execTest(){
        // 创建 beanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
    }
}
