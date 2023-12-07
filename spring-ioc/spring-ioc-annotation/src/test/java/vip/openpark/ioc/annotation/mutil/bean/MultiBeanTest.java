package vip.openpark.ioc.annotation.mutil.bean;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author anthony
 * @version 2023/12/7 21:41
 */
@Slf4j
public class MultiBeanTest {

	@Test
	public void test() {
		// 加载 spring 配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
		MultiBeanContainer bean = applicationContext.getBean(MultiBeanContainer.class);

		Map<String, MultiBean> beansOfType = applicationContext.getBeansOfType(MultiBean.class);
		// --> MultiBean spring bean 名称：[bean1, bean2, bean3, bean4]
		log.info("MultiBean spring bean 名称：{}", beansOfType.keySet());

		// --> [{"id":1},{"id":2},{"id":3},{"id":4}]
		log.info("{}", JSON.toJSONString(bean.getAllMultiBeans()));

		// -->  [{"id":3},{"id":4}]
		log.info("{}", JSON.toJSONString(bean.getBeanGroups()));
	}
}