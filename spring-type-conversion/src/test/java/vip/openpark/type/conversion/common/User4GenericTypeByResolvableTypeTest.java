package vip.openpark.type.conversion.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.core.ResolvableType;

/**
 * @author anthony
 * @since 2023/12/31 16:13
 */
@Slf4j
public class User4GenericTypeByResolvableTypeTest {
	@Test
	public void genericTypeTest() throws NoSuchMethodException {
		// StringList ——> ArrayList<String> ——> AbstractList<String> ———> AbstractCollection<String> ——> Object
		ResolvableType resolvableType = ResolvableType.forClass(StringList.class);
		ResolvableType superType = resolvableType.getSuperType();
		log.info("superType = {}", superType);
		
		ResolvableType superType1 = resolvableType.getSuperType().getSuperType();
		log.info("superType1 = {}", superType1);
		
		ResolvableType superType2 = resolvableType.getSuperType().getSuperType().getSuperType();
		log.info("superType2 = {}", superType2);
		
		ResolvableType superType3 = resolvableType.getSuperType().getSuperType().getSuperType().getSuperType();
		log.info("superType3 = {}", superType3);
		
		Class<?> resolve = resolvableType.asCollection().resolve();
		log.info("resolve = {}", resolve);
		
		// 获取泛型参数类型
		Class<?> aClass = resolvableType.asCollection().resolveGeneric(0);
		log.info("aClass = {}", aClass);
	}
}