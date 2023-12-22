package vip.openpark.bean.ioc.xml.bean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.SmartInitializingSingleton;

/**
 * @author anthony
 * @version 2023/12/22 16:55
 */
@Slf4j
@Data
public class UserBeanWithXMLSmartInitializingSingleton
	implements SmartInitializingSingleton {
	
	private Long id;
	private String name;
	private Short age;
	
	@Override
	public void afterSingletonsInstantiated() {
		log.info("this is {}", this);
	}
}