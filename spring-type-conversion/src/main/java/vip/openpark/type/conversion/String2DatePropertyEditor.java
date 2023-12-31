package vip.openpark.type.conversion;

import lombok.extern.slf4j.Slf4j;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <div>
 *     1.继承 PropertyEditorSupport 接口
 *     2.重写 setAsText 方法
 *     3.将字符串转换为 Date 对象
 * </div>
 *
 * @author anthony
 * @since 2023/12/31 9:38
 */
@Slf4j
public class String2DatePropertyEditor extends PropertyEditorSupport {
	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		log.info("字符串转换成 Date 对象{}", text);
		if (null == text || text.isEmpty()) {
			return;
		}
		
		try {
			// 3.将字符串转换为Properties对象
			// 创建 Date 对象
			Date parse = simpleDateFormat.parse(text);
			// 将 Date 对象赋值给 PropertyEditorSupport，临时存储 Date 对象
			setValue(parse);
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	@Override
	public String getAsText() {
		return simpleDateFormat.format((Date) getValue());
	}
}