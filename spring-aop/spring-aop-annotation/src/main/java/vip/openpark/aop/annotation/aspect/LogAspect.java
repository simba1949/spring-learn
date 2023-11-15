package vip.openpark.aop.annotation.aspect;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 定义切面
 * <a href="https://docs.spring.io/spring-framework/reference/core/aop/ataspectj/pointcuts.html">切入点表达式官方说明</a>
 * execution(权限修饰符 方法返回值 方法所在类全限定名.方法名 (参数列表)
 *
 * @author anthony
 * @version 2023/11/15 22:14
 */
@Slf4j
@Aspect // 表示该类是切面
@Component
public class LogAspect {

    /**
     * 前置通知
     */
    @Before(value = "execution(* vip.openpark.aop.annotation.example.CalculatorImpl.*(..))")
    public void before(JoinPoint joinPoint) {
        // 连接点处的签名
        Signature signature = joinPoint.getSignature();
        // 连接点处的签名的方法名称
        String methodName = signature.getName();
        // 连接点处的入参
        Object[] args = joinPoint.getArgs();
        log.info("前置通知：方法名称{}，方法参数{}", methodName, JSON.toJSONString(args));
    }

    /**
     * 返回通知
     * 可以在 returning 属性定义一个参数名，参数名要和方法形参名一致
     */
    @AfterReturning(value = "execution(* vip.openpark.aop.annotation.example.CalculatorImpl.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        log.info("返回通知：得到增强目标方法的返回值：{}", result);
    }

    /**
     * 异常通知
     * 可以在 throwing 属性定义一个异常名，异常名要和方法形参名一致
     */
    @AfterThrowing(value = "execution(* vip.openpark.aop.annotation.example.CalculatorImpl.*(..))", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
        log.error("异常通知，捕捉到异常信息：{}", ex.getMessage(), ex);
    }

    /**
     * 后置通知
     * 返回通知在后置通知之前执行
     */
    @After(value = "execution(* vip.openpark.aop.annotation.example.CalculatorImpl.*(..))")
    public void after(JoinPoint joinPoint) {
        log.info("后置通知");
    }

    /**
     * 环绕通知
     */
    @Around(value = "execution(* vip.openpark.aop.annotation.example.CalculatorImpl.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        Object result = null;
        try {
            log.info("环绕通知（前置通知）");
            result = proceedingJoinPoint.proceed(); // 调用目标方法
            log.info("环绕通知（返回通知）");
            return result;
        } catch (Throwable e) {
            log.info("环绕通知（异常通知）");
        } finally {
            log.info("环绕通知（后置通知）");
        }

        return result;
    }
}