package vip.openpark.bean.ioc.xml.bean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author anthony
 * @version 2023/12/22 17:12
 */
@Data
@Slf4j
public class UserBeanWithXmlDestructionAwareBeanPostProcessor {
	
	private Long id;
	private String name;
	private Short age;
}