package vip.openpark.type.conversion;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author anthony
 * @since 2023/12/31 9:41
 */
@Slf4j
public class String2DatePropertyEditorTest {
	
	@Test
	public void string2PropertiesTest() {
		// Date 文本
		String text = "2023年12月31日";
		
		// 转换为 Properties 对象
		String2DatePropertyEditor propertyEditor = new String2DatePropertyEditor();
		propertyEditor.setAsText(text);
		// 打印
		log.info("Date = {}", propertyEditor.getValue()); // 打印 Date
		log.info("Date = {}", propertyEditor.getAsText()); // 打印字符串
	}
}