package vip.openpark.aop.api.config;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.lang.NonNull;

import java.lang.reflect.Method;

/**
 * 自定义切点
 *
 * @author anthony
 * @since 2024/1/13 18:47
 */
@Slf4j
@Getter
@Setter
public class CustomPointcut extends StaticMethodMatcherPointcut {
	
	private String methodName;
	private Class<?> targetClass;
	
	public CustomPointcut(String methodName, Class<?> targetClass) {
		this.methodName = methodName;
		this.targetClass = targetClass;
	}
	
	/**
	 * 判断方法是否匹配
	 *
	 * @param method      方法
	 * @param targetClass 目标类
	 * @return true: 匹配 false: 不匹配
	 */
	@Override
	public boolean matches(Method method, @NonNull Class<?> targetClass) {
		return method.getName().equals(methodName) &&
			// 确定此Class对象表示的类或接口是否与指定Class参数表示的类或接口相同，或者是其超类或超接口。如果是，则返回true；否则返回false。
			this.targetClass.isAssignableFrom(targetClass);
	}
}