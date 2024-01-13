package vip.openpark.aop.xml.auto.proxy;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author anthony
 * @since 2024/1/13 22:23
 */
@Slf4j
public class EchoServiceMethodInterceptor implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		if (invocation.getMethod().getName().equals("echo")) {
			log.info("before echo");
			Object result = invocation.proceed();
			log.info("after echo");
			return result;
		}
		return null;
	}
}