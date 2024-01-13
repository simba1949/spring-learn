package vip.openpark.aop.api.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.ThrowsAdvice;

/**
 * @author anthony
 * @since 2024/1/13 21:44
 */
@Slf4j
public class CustomThrowsAdvice implements ThrowsAdvice {
	
	/**
	 * 参考 {@link ThrowsAdvice} 类上的注释内的方法
	 * 这里的方法名称必须是 afterThrowing
	 *
	 * @param ex 异常
	 */
	public void afterThrowing(Exception ex) {
		log.info("afterThrowing: {}", ex.getMessage(), ex);
	}
}