package vip.openpark.aop.aspectj;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import java.lang.reflect.Method;

/**
 * @author anthony
 * @since 2024/1/13 13:37
 */
@Slf4j
public class CalculateServiceTest {
	
	@Test
	public void aspectjAopTest() {
		// 创建被代理对象
		CalculateService calculateService = new CalculateService();
		// 创建代理工厂，并将代理对象设置进去
		AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory();
		aspectJProxyFactory.setTarget(calculateService);
		
		// 添加切面，这里基于方法级别进行增强
		aspectJProxyFactory.addAdvice(new MethodBeforeAdvice() {
			/**
			 * 增强前
			 * @param method 代理方法
			 * @param args 代理方法参数
			 * @param target 代理对象
			 * @throws Throwable 异常
			 */
			@Override
			@SuppressWarnings("all")
			public void before(Method method, Object[] args, Object target) throws Throwable {
				if (method.getName().equals("add")) {
					log.info("add before");
					log.info("add args: " + args[0] + ", " + args[1]);
					log.info("add target: " + target);
				}
			}
		});
		
		// 通过代理工厂获取代理对象
		CalculateService proxy = aspectJProxyFactory.getProxy();
		// 调用代理对象方法
		int addResult = proxy.add(1, 1);
		log.info("add result: " + addResult);
	}
}
