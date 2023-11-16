package vip.openpark.aop.xml.aspect;

import lombok.extern.slf4j.Slf4j;

/**
 * @author anthony
 * @version 2023/11/15 23:34
 */
@Slf4j
public class LogAspectTwo {

    /**
     * 不同切面中使用引用切入点
     */
    public void after() {
        log.info("后置通知");
    }
}