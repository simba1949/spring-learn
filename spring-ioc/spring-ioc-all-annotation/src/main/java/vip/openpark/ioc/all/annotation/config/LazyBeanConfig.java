package vip.openpark.ioc.all.annotation.config;

import org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author anthony
 * @version 2023/11/20 22:35
 */
@Configuration
public class LazyBeanConfig {

    @Bean
    public ObjectFactoryCreatingFactoryBean objectFactoryCreatingFactoryBean(){
        ObjectFactoryCreatingFactoryBean ofcfb = new ObjectFactoryCreatingFactoryBean();
        ofcfb.setTargetBeanName("user");
        return ofcfb;
    }
}
