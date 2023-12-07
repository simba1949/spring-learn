package vip.openpark.ioc.annotation.mutil.bean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author anthony
 * @version 2023/12/7 21:38
 */
@Configuration
public class MultiBeanConfig {

	@Bean
	public MultiBean bean1() { // 方法名为 spring bean 名称
		return MultiBean.builder().id(1L).build();
	}

	@Bean
	public MultiBean bean2() { // 方法名为 spring bean 名称
		return MultiBean.builder().id(2L).build();
	}

	@Bean
	@Qualifier("beanGroup") // 基于 @Qualifier 进行逻辑分组
	public MultiBean bean3() { // 方法名为 spring bean 名称
		return MultiBean.builder().id(3L).build();
	}

	@Bean
	@Qualifier("beanGroup") // 基于 @Qualifier 进行逻辑分组
	public MultiBean bean4() { // 方法名为 spring bean 名称
		return MultiBean.builder().id(4L).build();
	}
}