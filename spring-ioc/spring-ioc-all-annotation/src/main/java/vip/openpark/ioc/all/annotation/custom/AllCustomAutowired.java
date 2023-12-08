package vip.openpark.ioc.all.annotation.custom;

import java.lang.annotation.*;

/**
 * @author anthony
 * @version 2023/12/8 17:55
 */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AllCustomAutowired {
}