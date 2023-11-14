package vip.openpark.ioc.xml.component;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author anthony
 * @version 2023/11/14 19:59
 */
@Slf4j
public class DBInfoTest {
    @Test
    public void dbInfoTest() {
        // 加载 spring 配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("db.xml");
        // 获取创建的对象
        DBInfo dbInfo = applicationContext.getBean("dbInfo", DBInfo.class);
        log.info("{}", dbInfo);
    }
}
