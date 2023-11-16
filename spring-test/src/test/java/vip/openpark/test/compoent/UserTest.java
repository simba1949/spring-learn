package vip.openpark.test.compoent;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * 注解 @SpringJUnitConfig(locations = "")
 * 使用 spring-test 整合 junit5，指定配置文件位置，
 * spring-test 自动创建容器，并加载配置文件 bean，可以直接注入 spring bean 使用
 *
 * @author anthony
 * @version 2023/11/16 8:20
 */
@SpringJUnitConfig(locations = "classpath:bean.xml")
public class UserTest {
    @Resource
    private User user;

    @Test
    public void sayTest() {
        user.say("李白");
    }
}