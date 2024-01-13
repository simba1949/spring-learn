package vip.openpark.aop.api.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import vip.openpark.aop.api.example.IEchoService;
import vip.openpark.aop.api.example.impl.EchoServiceImpl;

/**
 * 自定义切面测试类
 *
 * @author anthony
 * @since 2024/1/13 18:51
 */
@Slf4j
public class CustomPointcutTest {
	
	@Test
	public void pointcutTest() {
		// 1. 为代理类创建一个切点
		CustomPointcut pointcut = new CustomPointcut("echo", IEchoService.class);
		// 2. 将 pointcut 适配成 Advisor
		DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor(pointcut, new CustomMethodInterceptor());
		// 3. 创建被代理对象
		IEchoService echoService = new EchoServiceImpl();
		
		// 4. 创建代理对象
		ProxyFactory proxyFactory = new ProxyFactory();
		// 5. 将被代理对象设置为代理对象的 targetSource
		proxyFactory.setTarget(echoService);
		// 5. 为代理对象添加通知（增强类）
		proxyFactory.addAdvisor(defaultPointcutAdvisor);
		
		// 6. 调用代理对象的方法
		IEchoService proxy = (IEchoService) proxyFactory.getProxy();
		proxy.echo("hello world");
	}
}