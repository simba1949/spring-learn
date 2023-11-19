package vip.openpark.i18n.bean;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * @author anthony
 * @version 2023/11/19 16:28
 */
@Component
public class CustomMessageSource {

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        // 设置 basename
        resourceBundleMessageSource.setBasename("spring");
        resourceBundleMessageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());

        return resourceBundleMessageSource;
    }
}