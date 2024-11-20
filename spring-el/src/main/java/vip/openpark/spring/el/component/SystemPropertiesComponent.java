package vip.openpark.spring.el.component;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 通过 spring el 获取系统属性
 *
 * @author anthony
 * @version 2024-11-20
 * @since 2024-11-20 14:09
 */
@Slf4j
@Data
@Component
public class SystemPropertiesComponent {

	@Value("#{systemProperties['user.name']}")
	private String username;

	@Value("#{systemProperties['user.timezone']}")
	private String timezone;

	@Value("#{systemProperties['user.dir']}")
	private String userHome;
}