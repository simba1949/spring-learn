package vip.openpark.aop.cjlib;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author anthony
 * @since 2024/1/12 21:30
 */
@Slf4j
public class CglibMethodInterceptor implements MethodInterceptor {
	
	/**
	 * 该方法是 cglib 生成的代理类的invoke方法
	 *
	 * @param obj         被代理对象
	 * @param method      被代理方法
	 * @param args        参数
	 * @param methodProxy 代理方法
	 * @return 被代理方法的返回值
	 * @throws Throwable 调用被代理方法时可能抛出的异常
	 */
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		log.info("cglib do something before");
		
		// result 是被代理方法的返回值
		Object result = methodProxy.invokeSuper(obj, args);
		
		log.info("cglib do something after");
		
		return result;
	}
}