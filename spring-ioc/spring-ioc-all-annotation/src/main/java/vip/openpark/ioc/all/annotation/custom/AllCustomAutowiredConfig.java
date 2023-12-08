package vip.openpark.ioc.all.annotation.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.Annotation;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.context.annotation.AnnotationConfigUtils.AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME;

/**
 * @author anthony
 * @version 2023/12/8 17:56
 */
@Configuration
public class AllCustomAutowiredConfig {

	@Bean(name = AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME)
	public static AutowiredAnnotationBeanPostProcessor beanPostProcessor() {
		AutowiredAnnotationBeanPostProcessor beanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
		// 保证自定义注解和 @Autowired 都生效
		Set<Class<? extends Annotation>> collect = Stream.of(Autowired.class, AllCustomAutowired.class).collect(Collectors.toSet());
		beanPostProcessor.setAutowiredAnnotationTypes(collect);
		return beanPostProcessor;
	}
}