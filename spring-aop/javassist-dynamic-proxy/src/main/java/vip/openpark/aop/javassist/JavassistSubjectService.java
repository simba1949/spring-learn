package vip.openpark.aop.javassist;

import lombok.extern.slf4j.Slf4j;

/**
 * @author anthony
 * @since 2024/1/12 21:48
 */
@Slf4j
public class JavassistSubjectService {
	public String sayHello(String name) {
		log.info("Hello {}", name);
		return "Hello " + name;
	}
}