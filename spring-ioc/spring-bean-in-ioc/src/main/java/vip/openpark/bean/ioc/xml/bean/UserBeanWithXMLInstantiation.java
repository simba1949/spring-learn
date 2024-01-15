package vip.openpark.bean.ioc.xml.bean;

/**
 * @author anthony
 * @version 2024/1/15 15:07
 */
public class UserBeanWithXMLInstantiation {
	private static final UserBeanWithXMLInstantiation instance = new UserBeanWithXMLInstantiation();
	
	private UserBeanWithXMLInstantiation() {
	}
	
	public static UserBeanWithXMLInstantiation createInstance() {
		return instance;
	}
}