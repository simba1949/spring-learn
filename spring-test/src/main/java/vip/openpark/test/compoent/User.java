package vip.openpark.test.compoent;

import lombok.extern.slf4j.Slf4j;

/**
 * @author anthony
 * @version 2023/11/16 8:20
 */
@Slf4j
public class User {

    public void say(String name) {
        log.info("Hello " + name);
    }
}