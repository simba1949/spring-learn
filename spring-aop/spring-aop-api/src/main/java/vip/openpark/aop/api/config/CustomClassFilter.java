package vip.openpark.aop.api.config;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.ClassFilter;
import org.springframework.lang.NonNull;

/**
 * @author anthony
 * @since 2024/1/14 17:49
 */
@Slf4j
@Getter
@Setter
public class CustomClassFilter implements ClassFilter {
	
	private Class<?> targetClass;
	
	public CustomClassFilter(Class<?> targetClass) {
		this.targetClass = targetClass;
	}
	
	@Override
	public boolean matches(@NonNull Class<?> clazz) {
		log.info("CustomClassFilter matches: {}", clazz);
		return targetClass.isAssignableFrom(clazz);
	}
}