package vip.openpark.aop.cglib;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author anthony
 * @since 2024/1/12 21:35
 */
@Slf4j
public class CglibSubjectServiceTest {
	/**
	 * 使用 JDK21 版本时需要添加 JVM 参数：--add-opens java.base/java.lang=ALL-UNNAMED
	 */
	@Test
	public void cglibDynamicProxyTest() {
		// 通过 cglib 代理工厂，创建代理对象
		CglibSubjectService proxy = CglibProxyFactory.getProxyObj(CglibSubjectService.class, new CglibMethodInterceptor());
		// 通过代理对象调用目标方法
		String result = proxy.sayHello("anthony");
		log.info("result is {}", result);
	}
}