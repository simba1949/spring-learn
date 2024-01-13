package vip.openpark.aop.api;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.lang.NonNull;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author anthony
 * @since 2024/1/13 18:46
 */
@Slf4j
public class BeforeAdviceTest {
	@Test
	public void beforeAdviceTest() {
		// 创建被代理对象
		Map<Object, Object> map = new HashMap<>();
		// 创建代理工厂
		AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory(map);
		aspectJProxyFactory.addAdvice(new MethodBeforeAdvice() {
			/**
			 * 前置通知
			 * @param method  the method being invoked
			 * @param args the arguments to the method
			 * @param target the target of the method invocation. May be {@code null}.
			 * @throws Throwable may be thrown to indicate that the method invocation should be aborted.
			 */
			@Override
			public void before(@NonNull Method method, @NonNull Object[] args, Object target) throws Throwable {
				if ("put".equals(method.getName())) {
					log.info("before put");
				}
			}
		});
		// 通过代理工厂获取代理对象
		Map<Object, Object> proxy = aspectJProxyFactory.getProxy();
		proxy.put("key", "value");
	}
}