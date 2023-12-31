package vip.openpark.type.conversion.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.core.GenericTypeResolver;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;
import java.util.Map;

/**
 * @author anthony
 * @since 2023/12/31 16:13
 */
@Slf4j
public class User4GenericTypeTest {
	@Test
	public void noGenericTypeTest() throws NoSuchMethodException {
		Method method = User4GenericType.class.getMethod("getName");
		// 常规类作为方法返回值
		Class<?> aClass = GenericTypeResolver.resolveReturnType(method, User4GenericType.class);
		// 返回 true
		log.info("{}", String.class.equals(aClass));
	}
	
	@Test
	public void genericTypeTest() throws NoSuchMethodException {
		display(User4GenericType.class, List.class, "getElements");
		
		display(User4GenericType.class, List.class, "getStrList");
	}
	
	/**
	 * 获取泛型类型变量的映射关系。
	 *
	 * @throws NoSuchMethodException 如果方法不存在时抛出该异常
	 */
	@Test
	public void typeVariableMapTest() throws NoSuchMethodException {
		Map<TypeVariable, Type> typeVariableMap = GenericTypeResolver.getTypeVariableMap(StringList.class);
		for (Map.Entry<TypeVariable, Type> entry : typeVariableMap.entrySet()) {
			log.info("key={},value={}", entry.getKey().getName(), entry.getValue());
		}
	}
	
	
	/**
	 * 显示类的名称、方法名称和方法的返回值类型。
	 *
	 * @param aClass     要显示的类对象
	 * @param genericIfc 泛型接口对象
	 * @param methodName 要显示的方法名
	 * @throws NoSuchMethodException 如果方法不存在时抛出该异常
	 */
	private void display(Class<?> aClass, Class<?> genericIfc, String methodName) throws NoSuchMethodException {
		Method method = aClass.getMethod(methodName);
		
		// 如果泛型接口为空，则将类对象作为方法返回值
		Class<?> aClass4NoGT = GenericTypeResolver.resolveReturnType(method, aClass);
		// 如果泛型接口不为空，则将泛型接口作为方法返回值
		Class<?> aClass4GT = GenericTypeResolver.resolveReturnTypeArgument(method, genericIfc);
		
		log.info("{}.{} | {} | {}", aClass.getName(), methodName, aClass4NoGT, aClass4GT);
	}
}