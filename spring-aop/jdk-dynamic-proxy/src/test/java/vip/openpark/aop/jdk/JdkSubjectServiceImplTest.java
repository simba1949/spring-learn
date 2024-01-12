package vip.openpark.aop.jdk;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
/**
 * @author anthony
 * @since 2024/1/12 21:20
 */
@Slf4j
public class JdkSubjectServiceImplTest {
	
	@Test
	public void jdkDynamicProxyTest() {
		// 1. 创建被代理对象
		JdkSubjectServiceImpl subject = new JdkSubjectServiceImpl();
		// 2. 创建代理对象
		IJdkSubjectService proxy = new JdkInvocationHandler<>(subject).getProxy();
		// 3. 调用代理对象的方法
		String result = proxy.sayHello("anthony");
		log.info("result is {}", result);
	}
}