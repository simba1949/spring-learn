package vip.openpark.resources;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

/**
 * @author anthony
 * @version 2023/11/19 9:54
 */
@Slf4j
public class UrlResourceTest {

    /**
     * 访问网络资源
     *
     * @throws IOException
     * @throws URISyntaxException
     */
    @Test
    public void httpTest() throws IOException, URISyntaxException {
        String url = "https://gitee.com/apache/dubbo/blob/3.2/README.md";
        UrlResource urlResource = new UrlResource(new URI(url));
        log.info("URL={}", urlResource.getURL());
        log.info("URI={}", urlResource.getURI());
        log.info("description={}", urlResource.getDescription());
        log.info("filename={}", urlResource.getFilename());
        log.info("content={}", urlResource.getContentAsString(StandardCharsets.UTF_8));
    }

    /**
     * 访问文件系统
     *
     * @throws IOException
     * @throws URISyntaxException
     */
    @Test
    public void fileTest() throws IOException, URISyntaxException {
        String url = "file:D:/IDE/IDEA/workspace/learn/spring-learn/spring-resources/src/main/resources/poem.txt";
        UrlResource urlResource = new UrlResource(new URI(url));
        log.info("URL={}", urlResource.getURL());
        log.info("URI={}", urlResource.getURI());
        log.info("File={}", urlResource.getFile());
        log.info("description={}", urlResource.getDescription());
        log.info("filename={}", urlResource.getFilename());
        log.info("content={}", urlResource.getContentAsString(StandardCharsets.UTF_8));
    }
}
