package vip.openpark.ioc.xml.component;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author anthony
 * @version 2023/11/14 19:05
 */
@Slf4j
public class CollectionComponentTest {

    @Test
    public void getBean() {
        // 加载 spring 配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        // 获取创建的对象
        CollectionComponent component = applicationContext.getBean("collectionComponent", CollectionComponent.class);
        log.info("{}", component);
    }
}
