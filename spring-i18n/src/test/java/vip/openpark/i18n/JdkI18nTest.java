package vip.openpark.i18n;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author anthony
 * @version 2023/11/19 16:06
 */
@Slf4j
public class JdkI18nTest {

    @Test
    public void jdkI18nChinaTest() {
        // 中国：Locale.CHINA
        // 美国：Locale.US
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jdk", Locale.CHINA);
        String string = resourceBundle.getString("language");
        log.info("language={}", string);
    }

    @Test
    public void jdkI18nUsTest() {
        // 中国：Locale.CHINA
        // 美国：Locale.US
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jdk", Locale.US);
        String string = resourceBundle.getString("language");
        log.info("language={}", string);
    }
}