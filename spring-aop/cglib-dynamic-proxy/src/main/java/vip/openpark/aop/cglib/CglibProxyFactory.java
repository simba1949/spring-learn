package vip.openpark.aop.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @author anthony
 * @since 2024/1/12 21:34
 */
public class CglibProxyFactory {
	@SuppressWarnings("unchecked")
	public static <T> T getProxyObj(Class<T> targetCls, MethodInterceptor methodInterceptor) {
		// 通过CGLIB动态代理获取代理对象的过程
		Enhancer enhancer = new Enhancer();
		// 设置enhancer对象的父类
		enhancer.setSuperclass(targetCls);
		// 设置enhancer的回调对象
		enhancer.setCallback(methodInterceptor);
		// 创建代理对象
		return (T) enhancer.create();
	}
}