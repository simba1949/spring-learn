package vip.openpark.ioc.xml.factorybean;

/**
 * @author anthony
 * @version 2023/11/25 15:34
 */
public class CustomServiceLoaderFactoryBeanOne implements CustomServiceLoaderFactoryBean {
    @Override
    public User createUser() {
        return CustomServiceLoaderFactoryBean.super.createUser();
    }
}