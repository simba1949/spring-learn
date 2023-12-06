package vip.openpark.ioc.all.annotation.component;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vip.openpark.ioc.all.annotation.config.SpringAnnotationConfig;

/**
 * @author anthony
 * @version 2023/12/6 23:12
 */
@Slf4j
public class BookBeanByAPITest {
    
    @Test
    public void exec() {
        // 加载 spring 配置类的方式
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringAnnotationConfig.class);
        // 将 BeanDefinition 注册到 spring ioc 容器中
        applicationContext.registerBeanDefinition("book", createBookBeanDefinition());
        
        Book book = applicationContext.getBean("book", Book.class);
        log.info("{}", book);
    }
    
    /**
     * 定义 BeanDefinition，用于注册 Book 作为 spring bean
     *
     * @return
     */
    public BeanDefinition createBookBeanDefinition() {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(Book.class);
        beanDefinitionBuilder.addPropertyValue("name", "《毛泽东选集》");
        beanDefinitionBuilder.addPropertyValue("price", "99.9");
        return beanDefinitionBuilder.getBeanDefinition();
    }
}