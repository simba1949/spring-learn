package vip.openpark.ioc.xml.component;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author anthony
 * @version 2023/11/13 21:16
 */
@Slf4j
public class UserComponentTest {

    @Test
    public void getUserComponentById() {
        // 加载 spring 配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        // 获取创建的对象
        UserComponent userComponent = (UserComponent) applicationContext.getBean("userComponent");
        log.info("{}", userComponent);
    }

    @Test
    public void getUserComponentByClass() {
        // 加载 spring 配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        // 获取创建的对象
        UserComponent userComponent = (UserComponent) applicationContext.getBean(UserComponent.class);
        log.info("{}", userComponent);
    }

    @Test
    public void getUserComponentByIdAndClass() {
        // 加载 spring 配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        // 获取创建的对象
        UserComponent userComponent = (UserComponent) applicationContext.getBean("userComponent", UserComponent.class);
        log.info("{}", userComponent);
    }
}