package vip.openpark.aop.api.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.AfterAdvice;

/**
 * @author anthony
 * @since 2024/1/13 21:54
 */
@Slf4j
public class CustomAfterAdvice implements AfterAdvice {
	public void after() {
		log.info("CustomAfterAdvice");
	}
}