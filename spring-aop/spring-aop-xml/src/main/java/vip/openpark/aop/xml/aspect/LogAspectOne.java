package vip.openpark.aop.xml.aspect;

import lombok.extern.slf4j.Slf4j;

/**
 * @author anthony
 * @version 2023/11/15 23:31
 */
@Slf4j
public class LogAspectOne {

    /**
     * 同一切面中使用引用切入点
     */
    public void afterReturning() {
        log.info("返回通知");
    }
}