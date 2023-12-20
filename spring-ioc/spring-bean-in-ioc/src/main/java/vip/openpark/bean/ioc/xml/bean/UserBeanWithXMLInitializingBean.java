package vip.openpark.bean.ioc.xml.bean;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.beans.factory.InitializingBean;

/**
 * <div>
 *     <title>注解 @PostConstruct、在XML中配置init-method方法、InitializingBean#afterPropertiesSet 方法同时存在时</title>
 *     执行顺序：
 *     1. @PostConstruct
 *     2. InitializingBean#afterPropertiesSet 方法
 *     3. InitializingBean#init 方法
 * </div>
 *
 * @author anthony
 * @version 2023/12/20 16:38
 */
@Data
public class UserBeanWithXMLInitializingBean implements InitializingBean {
	private Long id;
	private String name;
	private Short age;
	
	private String description;
	
	/**
	 * 注解 @PostConstruct ，在构造函数执行完毕后执行
	 */
	@PostConstruct
	public void postConstruct() {
		this.description = "PostConstruct 设置的值";
	}
	
	/**
	 * 自定义方法名称：
	 * 需要在 XML 中配置 init-method 属性，在构造函数执行完毕后执行
	 */
	public void init() {
		this.description = "init 设置的值";
	}
	
	/**
	 * 实现 InitializingBean 接口，在构造函数执行完毕后执行
	 *
	 * @throws Exception 异常
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		this.description = "InitializingBean 设置的值";
	}
}