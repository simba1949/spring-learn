package vip.openpark.aop.annotation.event.theory;

import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.event.EventPublicationInterceptor;
import org.springframework.lang.NonNull;

import java.lang.reflect.Method;

/**
 * <div>
 *     【注意：这里面的bean需要使用 static 修饰，提前初始化】
 *     1. @EnableAspectJAutoProxy 用于启用 aspectJ 的自动代理
 *     2. 事件发布拦截器
 *     3. 定义 pointcut
 *     4. 声明一个 Advisor
 * </div>
 *
 * @author anthony
 * @since 2024/1/21 10:21
 */
@Configurable
@EnableAspectJAutoProxy
public class ShowCallAopConfig {
	@Bean
	public static EventPublicationInterceptor eventPublicationInterceptor() {
		EventPublicationInterceptor eventPublicationInterceptor = new EventPublicationInterceptor();
		// 显示设置事件类型
		eventPublicationInterceptor.setApplicationEventClass(ShowCallEvent.class);
		return eventPublicationInterceptor;
	}
	
	@Bean
	public static Pointcut pointcut() {
		return new StaticMethodMatcherPointcut() {
			@Override
			public boolean matches(@NonNull Method method, @NonNull Class<?> targetClass) {
				return "execute".equals(method.getName()) && ShowCallAopExecutor.class.equals(targetClass);
			}
		};
	}
	
	@Bean
	public static PointcutAdvisor pointcutAdvisor(Pointcut pointcut, EventPublicationInterceptor eventPublicationInterceptor) {
		// EventPublicationInterceptor 等同于 MethodInterceptor 等同于 Advice
		return new DefaultPointcutAdvisor(pointcut, eventPublicationInterceptor);
	}
}