package vip.openpark.bean.ioc.xml.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author anthony
 * @version 2023/12/18 16:41
 */
@Data
@Component
public class BookBeanWithXMLInstantiationProcessor {
	private Long id;
	private String name;
}