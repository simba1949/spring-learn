package vip.openpark.aop.api.config;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.lang.NonNull;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author anthony
 * @since 2024/1/14 17:41
 */
@Slf4j
@Getter
@Setter
public class CustomStaticMethodMatcherPointcut extends StaticMethodMatcherPointcut {
	
	private String methodName; // 方法名
	private Class<?>[] parameterTypes; // 参数类型
	
	public CustomStaticMethodMatcherPointcut(String methodName, Class<?>[] parameterTypes) {
		this.methodName = methodName;
		this.parameterTypes = parameterTypes;
	}
	
	@Override
	public boolean matches(@NonNull Method method, @NonNull Class<?> targetClass) {
		log.debug("CustomStaticMethodMatcherPointcut matches method: {}, parameterTypes: {}", method.getName(), Arrays.toString(parameterTypes));
		if (!targetClass.equals(method.getDeclaringClass())) {
			// 方法所在目标类不匹配
			return false;
		}
		
		// 方法名称不匹配
		if (!Objects.equals(methodName, "") && !method.getName().equals(methodName)) {
			return false;
		}
		
		// 使用 java.util.Array.equals() 方法用于比较两个数组是否相等
		return Arrays.equals(parameterTypes, method.getParameterTypes());
	}
}