package vip.openpark.resources;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 访问类路径下资源
 *
 * @author anthony
 * @version 2023/11/19 10:19
 */
@Slf4j
public class ClassPathResourceTest {

    @Test
    public void classPathTest() throws IOException {
        String path = "poem.txt";
        ClassPathResource classPathResource = new ClassPathResource(path);
        log.info("URI={}", classPathResource.getURI());
        log.info("URL={}", classPathResource.getURL());
        log.info("PATH={}", classPathResource.getPath());
        log.info("description={}", classPathResource.getDescription());
        log.info("filename={}", classPathResource.getFilename());
        log.info("file={}", classPathResource.getFile());
        log.info("content={}", classPathResource.getContentAsString(StandardCharsets.UTF_8));
    }
}
