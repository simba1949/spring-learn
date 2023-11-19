package vip.openpark.resources;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ResourceLoader;
import vip.openpark.resources.bean.CustomResourceLoaderAware;
import vip.openpark.resources.config.SpringAnnotationConfig;

/**
 * @author anthony
 * @version 2023/11/19 11:17
 */
@Slf4j
public class CustomResourceLoaderAwareTest {

    @Test
    public void execTest() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringAnnotationConfig.class);
        CustomResourceLoaderAware customResourceLoaderAware = applicationContext.getBean(CustomResourceLoaderAware.class);
        ResourceLoader resourceLoader = customResourceLoaderAware.getResourceLoader();
        // Spring 容器自身完全可作为 ResourceLoader 使用
        log.info("{}", applicationContext == resourceLoader);
    }
}