package vip.openpark.ioc.xml.component;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author anthony
 * @version 2023/11/13 21:56
 */
@Slf4j
public class BookPTest {

    @Test
    public void diP() {
        // 加载 spring 配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("p-namespace.xml");
        // 获取创建的对象
        Book book = (Book) applicationContext.getBean("bookP");
        log.info("{}", book);
    }

}