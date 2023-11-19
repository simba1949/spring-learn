package vip.openpark.resources;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;

/**
 * @author anthony
 * @version 2023/11/19 11:00
 */
@Slf4j
public class ResourceLoaderTest {

    @Test
    public void getResourceByClassPathXmlApplicationContextTest() {
        // ClassPathXmlApplicationContext 对应的 Resource ==> ClassPathResource
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        // 通过 ApplicationContext 访问资源
        // ApplicationContext 实例获取 Resource 实例时，默认采用与 ApplicationContext 相同的资源访问策略
        Resource resource = applicationContext.getResource("poem.txt");
        log.info("{}", resource.getFilename());
    }


    @Test
    public void getResourceByFileSystemXmlApplicationContextTest() {
        // FileSystemXmlApplicationContext 对应的 Resource ==> FileSystemResource
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext();
        // 通过 ApplicationContext 访问资源
        // ApplicationContext 实例获取 Resource 实例时，默认采用与 ApplicationContext 相同的资源访问策略
        Resource resource = applicationContext.getResource("poem.txt");
        log.info("{}", resource.getFilename());
    }
}
