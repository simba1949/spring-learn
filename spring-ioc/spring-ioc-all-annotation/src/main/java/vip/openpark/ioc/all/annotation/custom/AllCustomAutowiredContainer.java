package vip.openpark.ioc.all.annotation.custom;

import lombok.Data;
import org.springframework.stereotype.Component;
import vip.openpark.ioc.all.annotation.component.User;

/**
 * @author anthony
 * @version 2023/12/8 18:01
 */
@Data
@Component
public class AllCustomAutowiredContainer {
	@AllCustomAutowired
	private User user;
}