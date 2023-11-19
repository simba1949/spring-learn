package vip.openpark.i18n;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vip.openpark.i18n.config.SpringAnnotationConfig;

import java.time.LocalDateTime;
import java.util.Locale;

/**
 * @author anthony
 * @version 2023/11/19 16:22
 */
@Slf4j
public class SpringI18nTest {

    @Test
    public void springI18nChinaTest() {
        // 加载 spring 配置类的方式
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringAnnotationConfig.class);

        Object[] objects = {"李白", LocalDateTime.now()};
        String welcome = applicationContext.getMessage("welcome", objects, Locale.CHINA);
        log.info("{}", welcome);
    }

    @Test
    public void springI18nUsTest() {
        // 加载 spring 配置类的方式
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringAnnotationConfig.class);

        Object[] objects = {"LiTaiBai", LocalDateTime.now()};
        String welcome = applicationContext.getMessage("welcome", objects, Locale.US);
        log.info("{}", welcome);
    }
}