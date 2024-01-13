package vip.openpark.aop.api;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.framework.adapter.ThrowsAdviceInterceptor;
import vip.openpark.aop.api.config.CustomThrowsAdvice;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author anthony
 * @since 2024/1/13 21:36
 */
@Slf4j
public class AfterThrowingAdviceTest {
	
	@Test
	public void afterThrowingAdviceTest() {
		// 创建被代理对象
		Map<String, Integer> map = new ConcurrentHashMap<>();
		// 创建代理工厂
		AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory(map);
		// 自定义异常拦截逻辑
		CustomThrowsAdvice customThrowsAdvice = new CustomThrowsAdvice();
		// 添加异常拦截逻辑
		aspectJProxyFactory.addAdvice(new ThrowsAdviceInterceptor(customThrowsAdvice));
		// 通过代理工厂获取代理对象
		Map<String, Integer> proxy = aspectJProxyFactory.getProxy();
		// ConcurrentHashMap key 不能为 null，这里通过 put null，执行异常的拦截方法
		proxy.put(null, null);
	}
}