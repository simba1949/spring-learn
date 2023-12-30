package vip.openpark.validation.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import vip.openpark.validation.common.UserWithHibernateValidator;

/**
 * @author anthony
 * @since 2023/12/30 15:49
 */
@Slf4j
@Controller
@Validated
public class UserController {

	public void insert(@Valid UserWithHibernateValidator user) {
		log.info("user:{}", user);
	}
}