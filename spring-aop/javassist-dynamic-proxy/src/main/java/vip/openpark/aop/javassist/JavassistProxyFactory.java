package vip.openpark.aop.javassist;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

/**
 * @author anthony
 * @since 2024/1/12 21:51
 */
public class JavassistProxyFactory {
	@SuppressWarnings("unchecked")
	public static <T> T getProxy(Class<T> targetCls, MethodHandler methodHandler) throws Exception {
		// 创建代理工厂
		ProxyFactory proxyFactory = new ProxyFactory();
		// 设置代理类的父类，也是被代理类
		proxyFactory.setSuperclass(targetCls);
		// 生成动态代理类
		Class<?> aClass = proxyFactory.createClass();
		// 创建动态代理类的实例
		// Object proxyInstance = aClass.newInstance(); // JDK8 使用 Class 创建实例方法
		Object proxyInstance = aClass.getDeclaredConstructor().newInstance(); // JDK9 使用 Class 创建实例方法
		// 设置动态处理方式
		((ProxyObject) proxyInstance).setHandler(methodHandler);
		
		return ((T) proxyInstance);
	}
}