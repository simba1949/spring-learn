package vip.openpark.aop.api;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import vip.openpark.aop.api.example.impl.HelloServiceImpl;
import vip.openpark.aop.api.example.IHelloService;

/**
 * @author anthony
 * @since 2024/1/13 16:51
 */
@Slf4j
public class ProxyFactoryTest {
	
	@Test
	public void proxyFactoryTest() {
		// 创建被代理对象
		IHelloService helloService = new HelloServiceImpl();
		// 创建代理工厂
		ProxyFactory proxyFactory = new ProxyFactory();
		// 设置被代理对象
		proxyFactory.setTarget(helloService);
		// 通过代理工厂获取代理对象
		IHelloService proxy = (IHelloService) proxyFactory.getProxy();
		// 调用代理对象的方法
		log.info("{}", proxy.sayHello("anthony"));
	}
}