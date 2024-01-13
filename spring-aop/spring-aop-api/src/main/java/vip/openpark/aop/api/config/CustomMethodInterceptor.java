package vip.openpark.aop.api.config;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * 自定义切点时：拦截到目标方法时执行的拦截器
 *
 * @author anthony
 * @since 2024/1/13 19:03
 */
@Slf4j
public class CustomMethodInterceptor implements MethodInterceptor {
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Method method = invocation.getMethod();
		log.info("method: {}, args: {}", method.getName(), invocation.getArguments());
		return invocation.proceed();
	}
}