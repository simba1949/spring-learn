package vip.openpark.bean.ioc.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 使用 {@link ComponentScan} 指定扫描包路径，value 表示具体的扫描包路径
 *
 * @author anthony
 * @version 2023/11/15 20:04
 */
@Configuration
@ComponentScan(value = "vip.openpark.bean.ioc")
public class SpringAnnotationConfig {
}