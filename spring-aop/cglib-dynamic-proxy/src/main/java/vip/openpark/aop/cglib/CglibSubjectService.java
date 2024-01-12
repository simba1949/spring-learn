package vip.openpark.aop.cglib;

import lombok.extern.slf4j.Slf4j;

/**
 * @author anthony
 * @since 2024/1/12 21:30
 */
@Slf4j
public class CglibSubjectService {
	public String sayHello(String name) {
		log.info("Hello {}", name);
		return "Hello " + name;
	}
}