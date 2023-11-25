package vip.openpark.ioc.xml.factorybean;

/**
 * @author anthony
 * @version 2023/11/25 15:10
 */
public interface CustomFactoryBeanInterface {
    default User createUser() {
        return new User();
    }
}