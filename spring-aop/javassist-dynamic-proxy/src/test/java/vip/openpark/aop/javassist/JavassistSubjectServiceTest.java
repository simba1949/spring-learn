package vip.openpark.aop.javassist;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author anthony
 * @since 2024/1/12 21:54
 */
@Slf4j
public class JavassistSubjectServiceTest {
	
	@Test
	public void javassistDynamicProxyTest() throws Exception {
		JavassistSubjectService proxy = JavassistProxyFactory.getProxy(JavassistSubjectService.class, new JavassistMethodHandler());
		// 执行代理方法
		String result = proxy.sayHello("anthony");
		log.info("result is {}", result);
	}
}