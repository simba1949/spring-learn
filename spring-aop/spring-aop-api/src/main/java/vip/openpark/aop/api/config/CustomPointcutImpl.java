package vip.openpark.aop.api.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.lang.NonNull;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author anthony
 * @since 2024/1/14 8:17
 */
@Slf4j
@Data
public class CustomPointcutImpl implements Pointcut {
	private Class<?> targetClass; // 目标类
	private String methodName; // 方法名
	private Class<?>[] parameterTypes; // 参数类型
	
	
	/**
	 * 创建 CustomPointcutImpl 实例时初始化
	 */
	public CustomPointcutImpl(Class<?> targetClass, String methodName, Class<?>[] parameterTypes) {
		this.targetClass = Objects.requireNonNull(targetClass, "Target class cannot be null");
		this.methodName = methodName;
		this.parameterTypes = Objects.requireNonNull(parameterTypes, "Parameter types cannot be null");
	}
	
	/**
	 * 用于类过滤
	 *
	 * @return ClassFilter
	 */
	@Override
	@NonNull
	public ClassFilter getClassFilter() {
		return new ClassFilter() {
			@Override
			public boolean matches(@NonNull Class<?> clazz) {
				return targetClass.isAssignableFrom(clazz);
			}
		};
	}
	
	/**
	 * 用于方法过滤
	 *
	 * @return MethodMatcher
	 */
	@Override
	@NonNull
	public MethodMatcher getMethodMatcher() {
		return new MethodMatcher() {
			@Override
			public boolean matches(@NonNull Method method, @NonNull Class<?> targetClass) {
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
			
			@Override
			public boolean isRuntime() {
				return false;
			}
			
			@Override
			public boolean matches(@NonNull Method method, @NonNull Class<?> targetClass, @NonNull Object... args) {
				return false;
			}
		};
	}
}