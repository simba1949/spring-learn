package vip.openpark.aop.annotation.event.theory;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * @author anthony
 * @since 2024/1/21 10:18
 */
@Slf4j
public class ShowCallAopExecutorTest {
	@Test
	public void eventTest() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 指定配置类
		applicationContext.register(ShowCallAopConfig.class, ShowCallAopExecutor.class, ShowCallListener.class);
		// 启动应用上下文
		applicationContext.refresh(); // ContextRefreshedEvent
		
		ShowCallAopExecutor bean = applicationContext.getBean(ShowCallAopExecutor.class);
		bean.execute();
		
		// 关闭应用上下文
		applicationContext.close();
	}
}