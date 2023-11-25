package vip.openpark.ioc.xml.factorybean;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vip.openpark.ioc.xml.component.Book;

/**
 * @author anthony
 * @version 2023/11/26 5:09
 */
@Slf4j
public class HierarchicalBeanFactoryTest {
    @Test
    public void execTest(){
        // 加载 spring 配置文件
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("p-namespace.xml");
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        // 获取创建的对象
        Book book = (Book) applicationContext.getBean("bookP");
        log.info("{}", book);
    }
}
