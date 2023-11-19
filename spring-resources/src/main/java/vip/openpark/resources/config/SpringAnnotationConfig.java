package vip.openpark.resources.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author anthony
 * @version 2023/11/19 11:15
 */
@Configuration
// @ComponentScan 指定扫描包路径
@ComponentScan(value = "vip.openpark.resources")
public class SpringAnnotationConfig {
}
