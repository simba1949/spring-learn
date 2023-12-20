package vip.openpark.bean.ioc.annotation.bean;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author anthony
 * @version 2023/12/20 16:38
 */
@Data
@Component
public class UserBeanWithAnnotationInitializingBean implements InitializingBean {
	private Long id;
	private String name;
	private Short age;
	
	private String description;
	
	/**
	 * 注解 @PostConstruct ，在构造函数执行完毕后执行
	 * 只能使用注解的方式，在 XML 配置无法执行
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
	 * <div>
	 *     <title>使用注解配置时</title>
	 *     <div>
	 *         注解 @PostConstruct 和  InitializingBean#afterPropertiesSet 方法同时存在时
	 *         优先执行 @PostConstruct，然后执行 InitializingBean#afterPropertiesSet 方法
	 *     </div>
	 *
	 *     <title>使用 XML 配置时</title>
	 *     <div>
	 *         在 XML 中配置 init-method 方法和  InitializingBean#afterPropertiesSet 方法同时存在时
	 *         优先执行 InitializingBean#afterPropertiesSet 方法，然后执行 init-method 方法
	 *     </div>
	 * </div>
	 * 实现 InitializingBean 接口，在构造函数执行完毕后执行
	 *
	 * @throws Exception 异常
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		this.description = "InitializingBean 设置的值";
	}
}