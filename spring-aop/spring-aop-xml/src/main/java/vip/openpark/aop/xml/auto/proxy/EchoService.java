package vip.openpark.aop.xml.auto.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author anthony
 * @since 2024/1/13 22:21
 */
@Slf4j
public class EchoService {
	public void echo(String msg) {
		log.info("echo: {}", msg);
	}
}