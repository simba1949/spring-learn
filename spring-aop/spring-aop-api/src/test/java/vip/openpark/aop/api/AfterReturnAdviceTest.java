package vip.openpark.aop.api;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.lang.NonNull;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author anthony
 * @since 2024/1/13 21:36
 */
@Slf4j
public class AfterReturnAdviceTest {
	
	@Test
	public void afterReturnAdviceTest() {
		// 创建被代理对象
		Map<Object, Object> map = new HashMap<>();
		// 创建代理工厂
		AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory(map);
		// AfterReturningAdvice
		aspectJProxyFactory.addAdvice(new AfterReturningAdvice() {
			/**
			 * Called after the method has been invoked and its return value is being returned to the caller.
			 * @param returnValue the value returned by the method, if any
			 * @param method the method being invoked
			 * @param args the arguments to the method
			 * @param target the target of the method invocation. May be {@code null}.
			 * @throws Throwable may be thrown by the advice, if it wants to throw an exception.
			 */
			@Override
			public void afterReturning(Object returnValue, @NonNull Method method, @NonNull Object[] args, Object target) throws Throwable {
				// 这里判断方法名，如果为 get 则输出
				if ("get".equals(method.getName())) {
					log.info("afterReturning: {}", returnValue);
				}
			}
		});
		// 通过代理工厂获取代理对象
		Map<Object, Object> proxy = aspectJProxyFactory.getProxy();
		proxy.put("key", "value");
		log.info("{}", proxy.get("key"));
	}
}