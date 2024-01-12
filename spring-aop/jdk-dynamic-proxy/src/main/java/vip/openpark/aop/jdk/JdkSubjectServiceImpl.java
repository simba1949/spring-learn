package vip.openpark.aop.jdk;

import lombok.extern.slf4j.Slf4j;

/**
 * @author anthony
 * @since 2024/1/12 21:11
 */
@Slf4j
public class JdkSubjectServiceImpl implements IJdkSubjectService {
	@Override
	public String sayHello(String name) {
		log.info("Hello {}", name);
		return "Hello " + name;
	}
}