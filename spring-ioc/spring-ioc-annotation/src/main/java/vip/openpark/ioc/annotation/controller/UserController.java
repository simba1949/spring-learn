package vip.openpark.ioc.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import vip.openpark.ioc.annotation.service.UserService;

/**
 * @author anthony
 * @version 2023/11/14 21:43
 */
@Controller
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;
}
