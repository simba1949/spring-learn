package vip.openpark.aop.annotation.event.theory;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * @author anthony
 * @since 2024/1/21 10:44
 */
@Slf4j
public class ShowCallManualExecutorTest {
	@Test
	public void eventTest() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 指定配置类
		applicationContext.register(ShowCallManualExecutor.class, ShowCallListener.class);
		// 启动应用上下文
		applicationContext.refresh(); // ContextRefreshedEvent
		
		ShowCallManualExecutor bean = applicationContext.getBean(ShowCallManualExecutor.class);
		bean.execute();
		
		// 关闭应用上下文
		applicationContext.close();
	}
}