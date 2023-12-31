package vip.openpark.type.conversion;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

/**
 * <div>
 *     String（yyyy年MM月dd日） ——> Date
 * </div>
 *
 * @author anthony
 * @since 2023/12/31 13:53
 */
@Slf4j
public class CustomConditionalGenericConverter implements ConditionalGenericConverter {
	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
	
	/**
	 * 判断是否可以转换
	 *
	 * @param sourceType 源类型
	 * @param targetType 目标类型
	 * @return 是否可以转换
	 */
	@Override
	public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
		return String.class.equals(sourceType.getType()) && Date.class.equals(targetType.getType());
	}
	
	
	/**
	 * 获取可转换的类型集合
	 *
	 * @return 返回一个包含String类到Date类的可转换对的集合
	 */
	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		return Collections.singleton(new ConvertiblePair(String.class, Date.class));
	}
	
	/**
	 * 转换
	 *
	 * @param source     源对象
	 * @param sourceType 源类型
	 * @param targetType 目标类型
	 * @return 转换后的对象
	 */
	@Override
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
		String text = (String) source;
		log.info("字符串转换成 Date 对象{}", text);
		if (null == text || text.isEmpty()) {
			return null;
		}
		
		try {
			return simpleDateFormat.parse(text);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}