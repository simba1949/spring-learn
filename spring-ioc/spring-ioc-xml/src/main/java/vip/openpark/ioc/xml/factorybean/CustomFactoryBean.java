package vip.openpark.ioc.xml.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author anthony
 * @version 2023/11/14 20:43
 */
public class CustomFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}