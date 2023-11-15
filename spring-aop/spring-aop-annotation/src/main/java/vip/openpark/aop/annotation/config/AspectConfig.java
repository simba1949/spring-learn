package vip.openpark.aop.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author anthony
 * @version 2023/11/15 22:23
 */
@ComponentScan("vip.openpark.aop.annotation") // 开启组件扫描
@EnableAspectJAutoProxy // 开启 aspectj 自动代理，为目标对象生成代理
@Configuration
public class AspectConfig {
}