package vip.openpark.aop.annotation.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author anthony
 * @version 2023/11/15 23:31
 */
@Slf4j
@Aspect // 表示该类是切面
@Component
public class LogAspectOneWithPointCut {

    /**
     * 声明切入点
     */
    @Pointcut("execution(* vip.openpark.aop.annotation.example.CalculatorImpl.*(..))")
    public void pointcut() {
    }

    /**
     * 同一切面中使用引用切入点
     */
    @AfterReturning("pointcut()")
    public void afterReturning() {
        log.info("返回通知：同一切面中使用");
    }
}