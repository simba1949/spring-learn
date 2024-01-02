package vip.openpark.annotation;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

/**
 * @author anthony
 * @since 2024/1/2 23:33
 */
@Configurable
public class HelloWorldConfiguration {
	
	/**
	 * 自定义的 bean
	 *
	 * @return 返回一个自定义的 bean
	 */
	@Bean
	public String helloWorld() {
		return "Hello World!";
	}
}