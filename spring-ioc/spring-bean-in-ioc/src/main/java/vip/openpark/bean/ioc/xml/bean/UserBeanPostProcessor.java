package vip.openpark.bean.ioc.xml.bean;

import lombok.Data;

/**
 * <div>
 *     spring bean 实例化前后操作
 * </div>
 * {@link vip.openpark.bean.ioc.xml.bean.config.CustomBeanPostProcessor}
 *
 * @author anthony
 * @version 2023/12/20 16:20
 */
@Data
public class UserBeanPostProcessor {
	private Long id;
	private String name;
	private Short age;
	
	private String description;
}