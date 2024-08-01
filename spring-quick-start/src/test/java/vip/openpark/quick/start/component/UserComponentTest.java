package vip.openpark.quick.start.component;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author anthony
 * @version 2023/11/13 20:03
 */
public class UserComponentTest {

    @Test
    public void getUserComponent() {
        // 使用 ClassPathXmlApplicationContext 加载 spring 配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        // 获取创建的对象
        UserComponent userComponent = (UserComponent) applicationContext.getBean("userComponent");
        // 使用对象调用方法
        userComponent.sayHello();
    }

    /**
     * JDK21 通过反射创建对象
     */
    @Test
    public void createObjByReflect() throws Exception {
        Class<?> aClass = Class.forName("vip.openpark.quick.start.component.UserComponent");
        UserComponent userComponent = (UserComponent) aClass.getDeclaredConstructor().newInstance();
        userComponent.sayHello();
    }
}