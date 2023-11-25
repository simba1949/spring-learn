package vip.openpark.ioc.xml.factorybean;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ServiceLoader;

/**
 * @author anthony
 * @version 2023/11/25 15:39
 */
@Slf4j
public class CustomServiceLoaderFactoryBeanTest {
    /**
     * 基于 JDK ServiceLoader 方式加载 spring bean
     */
    @Test
    public void execTest() {
        // 加载 spring 配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("custom-service-loader.xml");
        // 获取 ServiceLoader
        ServiceLoader<CustomServiceLoaderFactoryBean> serviceLoader = applicationContext.getBean("customServiceLoaderFactoryBean", ServiceLoader.class);
        for (CustomServiceLoaderFactoryBean customServiceLoaderFactoryBean : serviceLoader) {
            log.info("user={}", customServiceLoaderFactoryBean.createUser());
        }
    }

    /**
     * 基于 JDK ServiceLoader 方式加载 spring bean
     */
    @Test
    public void autowireTest() {
        // 加载 spring 配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("custom-service-loader.xml");
        // 获取 AutowireCapableBeanFactory
        AutowireCapableBeanFactory autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
        // 创建 CustomServiceLoaderFactoryBeanDefault，这里必须是实现类
        CustomServiceLoaderFactoryBeanDefault bean = autowireCapableBeanFactory.createBean(CustomServiceLoaderFactoryBeanDefault.class);
        log.info("{}", bean.createUser());

    }

    /**
     * 基于 JDK ServiceLoader 加载
     */
    @Test
    public void loadTest() {
        ServiceLoader<CustomServiceLoaderFactoryBean> serviceLoader = ServiceLoader.load(CustomServiceLoaderFactoryBean.class, Thread.currentThread().getContextClassLoader());
        for (CustomServiceLoaderFactoryBean next : serviceLoader) {
            log.info("user={}", next.createUser());
        }
    }
}