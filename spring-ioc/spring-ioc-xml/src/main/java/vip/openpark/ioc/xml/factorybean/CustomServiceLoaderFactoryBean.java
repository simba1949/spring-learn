package vip.openpark.ioc.xml.factorybean;

/**
 * @author anthony
 * @version 2023/11/25 15:33
 */
public interface CustomServiceLoaderFactoryBean {
    default User createUser(){
        // 这里可以在 User 类中设置单例
        return new User();
    }
}