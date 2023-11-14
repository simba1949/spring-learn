package vip.openpark.ioc.xml.component;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vip.openpark.ioc.xml.bean.life.BeanLifeCycle;

/**
 * @author anthony
 * @version 2023/11/14 20:27
 */
@Slf4j
public class BeanLifeCycleTest {
    @Test
    public void beanLifeCycleTest() {
        // 加载 spring 配置文件
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-lifecycle.xml");
        // 获取创建的对象
        BeanLifeCycle beanLifeCycle = applicationContext.getBean("bookLifeCycle", BeanLifeCycle.class);
        log.info("{}", beanLifeCycle);
        // 关闭容器，对象自动
        applicationContext.close();
    }
}