package vip.openpark.bean.ioc.xml.bean;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author anthony
 * @version 2023/12/29 16:34
 */
@Slf4j
public class YamlMapFactoryBeanTest {
	/**
	 * 使用 ClassPathXmlApplicationContext 创建 spring ioc 容器，并指定配置文件位置
	 * <div>
	 *     这里需要依赖 snakeyaml 依赖
	 *     <a href="https://mvnrepository.com/artifact/org.yaml/snakeyaml">snakeyaml</a>
	 * </div>
	 */
	@Test
	public void runSpringIocWithClassPathXmlApplicationContextTest() {
		// 加载 spring 配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:bean-YamlMapFactoryBean.xml");
		
		// 获取 bean
		Map<String, Object> bean = applicationContext.getBean("yamlMapFactoryBean", Map.class);
		log.info("bean = {}", bean);
	}
}