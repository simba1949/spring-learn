package vip.openpark.ioc.java.beans;

import vip.openpark.ioc.java.beans.bean.User;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.stream.Stream;

/**
 * {@link java.beans.BeanInfo}
 * {@link java.beans.Introspector}
 *
 * @author anthony
 * @version 2023/11/20 21:25
 */
public class IocByJavaBeansApplication {
    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(User.class, Object.class);
        // 获取属性描述
        Stream.of(beanInfo.getPropertyDescriptors()).forEach(System.out::println);
    }
}
