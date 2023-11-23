package vip.openpark.ioc.xml.factorybean;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import vip.openpark.ioc.xml.component.Book;

/**
 * @author anthony
 * @version 2023/11/23 20:51
 */
@Slf4j
public class BeanDefinitionBuilderTest {

    @Test
    public void createBeanTest(){
        // 1. 通过 BeanDefinitionBuilder 构建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(Book.class);
        // 设置属性
        beanDefinitionBuilder.addPropertyValue("name", "《遗忘清单》");
        // 获取 BeanDefinition 实例名，BeanDefinition 并非 bean 的终态，还可以继续修改
        BeanDefinition beanDefinition1 = beanDefinitionBuilder.getBeanDefinition();

        // 2. 通过 AbstractBeanDefinition 以及派生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(Book.class);
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("name", "Ray");
        genericBeanDefinition.setPropertyValues(propertyValues);
        BeanDefinition beanDefinition2 = genericBeanDefinition.cloneBeanDefinition();
    }
}