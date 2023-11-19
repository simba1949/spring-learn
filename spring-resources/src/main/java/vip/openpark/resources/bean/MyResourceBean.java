package vip.openpark.resources.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
/**
 * @author anthony
 * @version 2023/11/19 15:18
 */
@Data
@Component
public class MyResourceBean {

    /**
     * 指定资源路径
     */
    @Value("classpath:poem.txt")
    private Resource resource;
}