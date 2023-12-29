package vip.openpark.bean.ioc.annotation.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

/**
 * @author anthony
 * @version 2023/12/29 15:27
 */
@Data
@PropertySource(value = "classpath:property-source.properties")
public class PropertySourceConfig {
	@Value("${name}")
	private String name;
	@Value("${age}")
	private Integer age;
}