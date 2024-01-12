package vip.openpark.aop.javassist;

import javassist.util.proxy.MethodHandler;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

/**
 * @author anthony
 * @since 2024/1/12 21:49
 */
@Slf4j
public class JavassistMethodHandler implements MethodHandler {
	/**
	 * @param self       - 代理对象
	 * @param thisMethod - 表示被拦截的方法
	 * @param proceed    - 表示要触发父类的方法
	 * @param args       - 参数
	 * @return 返回值
	 * @throws Throwable - 异常
	 */
	@Override
	public Object invoke(Object self, Method thisMethod, Method proceed, Object[] args) throws Throwable {
		log.info("javassist do something before");
		// result 是返回结果
		Object result = proceed.invoke(self, args);
		log.info("javassist do something after");
		return result;
	}
}