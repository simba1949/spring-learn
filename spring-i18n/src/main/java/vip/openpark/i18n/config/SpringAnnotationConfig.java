package vip.openpark.i18n.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author anthony
 * @version 2023/11/19 16:26
 */
@Configuration
// @ComponentScan 指定扫描包路径
@ComponentScan(value = "vip.openpark.i18n")
public class SpringAnnotationConfig {
}
