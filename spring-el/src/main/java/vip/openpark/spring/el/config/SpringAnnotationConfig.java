package vip.openpark.spring.el.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author anthony
 * @version 2023/11/15 20:04
 */
@Configuration
// @ComponentScan 指定扫描包路径
@ComponentScan(value = "vip.openpark.spring.el")
public class SpringAnnotationConfig {
}