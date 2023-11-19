package vip.openpark.resources;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.FileSystemResource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author anthony
 * @version 2023/11/19 10:28
 */
@Slf4j
public class FileSystemResourceTest {

    @Test
    public void fileTest() throws IOException {
        String path = "src/main/resources/poem.txt";
        FileSystemResource fileSystemResource = new FileSystemResource(path);
        log.info("file={}", fileSystemResource.getFile());
        log.info("URL={}", fileSystemResource.getURL());
        log.info("filename={}", fileSystemResource.getFilename());
        log.info("desc={}", fileSystemResource.getDescription());
        log.info("URI={}", fileSystemResource.getURI());
        log.info("path={}", fileSystemResource.getPath());
        log.info("content={}", fileSystemResource.getContentAsString(StandardCharsets.UTF_8));
    }
}
