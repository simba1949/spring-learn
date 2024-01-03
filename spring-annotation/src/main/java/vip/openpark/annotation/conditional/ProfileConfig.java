package vip.openpark.annotation.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author anthony
 * @version 2024/1/3 12:33
 */
@Configuration
public class ProfileConfig {
	
	@Bean(name = "number")
	@Profile("odd") // 基于配置条件注解
	@Conditional(OddCondition.class) // 基于条件注解
	public Integer oddNumber() {
		return 1;
	}
	
	@Bean(name = "number")
	@Profile("even")
	public Integer evenNumber() {
		return 2;
	}
}