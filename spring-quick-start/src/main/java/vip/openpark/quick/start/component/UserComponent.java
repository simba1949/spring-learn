package vip.openpark.quick.start.component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author anthony
 * @version 2024/08/01
 * @since 2023/11/13 20:01
 */
@Slf4j
public class UserComponent {

    public UserComponent() {
        log.info("无参构造函数被调用了！");
    }

    public void sayHello() {
        log.info("UserComponent say hello!");
    }
}