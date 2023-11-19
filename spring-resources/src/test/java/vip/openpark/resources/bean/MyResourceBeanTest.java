package vip.openpark.resources.bean;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;
import vip.openpark.resources.config.SpringAnnotationConfig;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author anthony
 * @version 2023/11/19 15:33
 */
@Slf4j
public class MyResourceBeanTest {

    @Test
    public void execTest() throws IOException {
        // 加载 spring 配置类的方式
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringAnnotationConfig.class);
        MyResourceBean myResourceBean = applicationContext.getBean(MyResourceBean.class);

        Resource resource = myResourceBean.getResource();
        log.info("file={}", resource.getFile());
        log.info("URL={}", resource.getURL());
        log.info("filename={}", resource.getFilename());
        log.info("desc={}", resource.getDescription());
        log.info("URI={}", resource.getURI());
        log.info("content={}", resource.getContentAsString(StandardCharsets.UTF_8));
    }
}
