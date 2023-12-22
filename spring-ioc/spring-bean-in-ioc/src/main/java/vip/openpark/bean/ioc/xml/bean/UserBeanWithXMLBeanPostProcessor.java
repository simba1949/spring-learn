package vip.openpark.bean.ioc.xml.bean;

import lombok.Data;
import vip.openpark.bean.ioc.xml.config.CustomBeanPostProcessor;

/**
 * <div>
 *     spring bean 实例化前后操作
 * </div>
 * {@link CustomBeanPostProcessor}
 *
 * @author anthony
 * @version 2023/12/20 16:20
 */
@Data
public class UserBeanWithXMLBeanPostProcessor {
	private Long id;
	private String name;
	private Short age;
	
	private String description;
}