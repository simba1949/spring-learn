package vip.openpark.aop.jdk;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author anthony
 * @since 2024/1/12 21:13
 */
@Slf4j
public class JdkInvocationHandler<T> implements InvocationHandler {
	/**
	 * 被代理的对象
	 */
	private final T target;
	
	public JdkInvocationHandler(T target) {
		this.target = target;
	}
	
	/**
	 * 获取代理对象
	 *
	 * @return 代理对象
	 */
	@SuppressWarnings("unchecked")
	public T getProxy() {
		// 第一个参数是类加载器，用于加载这个代理类，可以通过目标对象获取类加载器
		// 第二个参数是Class数组，里面存放的是待实现的接口信息
		// 第三个参数是 InvocationHandler 实例，代理对象的调用处理程序
		return (T) Proxy.newProxyInstance(
			target.getClass().getClassLoader(),
			target.getClass().getInterfaces(),
			this);
	}
	
	/**
	 * 代理方法
	 *
	 * @param proxy  代理对象
	 * @param method 被代理的方法
	 * @param args   被代理方法的参数
	 * @return 被代理方法的返回值
	 * @throws Throwable 代理方法的异常
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		log.info("do something before");
		
		// result 是被代理方法的返回值
		Object result = method.invoke(target, args);
		
		log.info("do something after");
		return result;
	}
}