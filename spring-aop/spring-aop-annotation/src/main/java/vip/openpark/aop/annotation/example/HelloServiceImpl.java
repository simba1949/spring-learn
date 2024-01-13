package vip.openpark.aop.annotation.example;

import lombok.extern.slf4j.Slf4j;

/**
 * @author anthony
 * @since 2024/1/13 16:53
 */
@Slf4j
public class HelloServiceImpl implements IHelloService {
	@Override
	public String sayHello(String name) {
		log.info("HelloServiceImpl#sayHello execute");
		return "Hello " + name;
	}
}