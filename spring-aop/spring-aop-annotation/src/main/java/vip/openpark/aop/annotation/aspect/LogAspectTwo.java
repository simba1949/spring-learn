package vip.openpark.aop.annotation.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author anthony
 * @version 2023/11/15 23:34
 */
@Slf4j
@Aspect // 表示该类是切面
@Component
public class LogAspectTwo {

    /**
     * 不同切面中使用引用切入点
     */
    @After("vip.openpark.aop.annotation.aspect.LogAspectOneWithPointCut.pointcut()")
    public void before() {
        log.info("后置通知：不同切面中使用");
    }
}