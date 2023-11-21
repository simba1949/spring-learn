package vip.openpark.ioc.xml.factorybean;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author anthony
 * @version 2023/11/21 23:41
 */
@Slf4j
public class IOCContainerTest {

    @Test
    public void execTest(){
        // 创建 beanFactory 容器
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        // 读取使用 XML 配置的 bean
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        String location = "classpath:bean.xml";
        // 加载 XML 配置，返回配置 bean 的数量
        int beanDefinitionCount = xmlBeanDefinitionReader.loadBeanDefinitions(location);
        log.info("{}", beanDefinitionCount);
    }
}
