package vip.openpark.annotation.enable;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * <div>
 *     第一步：自定义 @EnableXXX 注解
 *     第二步：使用 {@link Import} 注解，并指定配置类/导入选择器/导入注册器
 *     第三步：一般在启动类中使用自定义的 @EnableXXX 注解
 * </div>
 *
 * @author anthony
 * @since 2024/1/2 23:31
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
// @Import(HelloWorldConfiguration.class) // 指定配置类
// @Import(HelloWorldImportSelector.class) // 指定导入选择器
@Import(HelloWorldImportBeanDefinitionRegistrar.class) // 指定导入注册器
public @interface EnableHelloWorld {
}