package vip.openpark.bean.ioc.xml.bean;

import lombok.Data;
import org.springframework.stereotype.Component;
import vip.openpark.bean.ioc.xml.config.CustomInstantiationAwareBeanPostProcessor;

/**
 * <div>
 *     在 spring bean 实例化之前后进行处理器操作
 * </div>
 * {@link CustomInstantiationAwareBeanPostProcessor}
 *
 * @author anthony
 * @version 2023/12/18 16:41
 */
@Data
@Component
public class UserBeanWithXMLInstantiationAwareBeanPostProcessor {
	private Long id;
	private String name;
}