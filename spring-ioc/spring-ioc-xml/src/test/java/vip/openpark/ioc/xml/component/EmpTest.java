package vip.openpark.ioc.xml.component;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author anthony
 * @version 2023/11/14 18:44
 */
@Slf4j
public class EmpTest {
    @Test
    public void getBeanByRefBean() {
        // 加载 spring 配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        // 获取创建的对象
        Emp emp = (Emp) applicationContext.getBean("emp");
        log.info("{}", emp);
    }

    @Test
    public void getBeanByInnerBean() {
        // 加载 spring 配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        // 获取创建的对象
        Emp emp = (Emp) applicationContext.getBean("empInnerBean");
        log.info("{}", emp);
    }

    @Test
    public void getBeanByCascade() {
        // 加载 spring 配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        // 获取创建的对象
        Emp emp = (Emp) applicationContext.getBean("empCascade");
        log.info("{}", emp);
    }
}
