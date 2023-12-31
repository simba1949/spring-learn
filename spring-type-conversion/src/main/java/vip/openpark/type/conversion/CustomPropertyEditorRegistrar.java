package vip.openpark.type.conversion;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

import java.util.Date;

/**
 * <div>
 *     <title>自定义 PropertyEditor 注册</title>
 *     1.实现 PropertyEditorRegistrar 接口
 *     2.重写 registerCustomEditors 方法
 *     3.使用 @Component 或者 XML 方式注册成 spring bean
 * </div>
 *
 * @author anthony
 * @since 2023/12/31 10:02
 */
public class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {
	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(Date.class, new String2DatePropertyEditor());
	}
}