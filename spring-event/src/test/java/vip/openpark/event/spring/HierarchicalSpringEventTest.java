package vip.openpark.event.spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author anthony
 * @since 2024/1/1 10:58
 */
@Slf4j
public class HierarchicalSpringEventTest {
	
	@Test
	public void hierarchicalSpringEventTest() {
		// 创建 parent spring 应用上下文
		AnnotationConfigApplicationContext parentApplicationContext = new AnnotationConfigApplicationContext();
		parentApplicationContext.setId("parent-applicationContext");
		// 注册监听器
		parentApplicationContext.register(CustomContextRefreshedEventListener.class);
		
		// 创建 son spring 应用上下文
		AnnotationConfigApplicationContext sonApplicationContext = new AnnotationConfigApplicationContext();
		sonApplicationContext.setId("son-applicationContext");
		// 注册监听器
		sonApplicationContext.register(CustomContextRefreshedEventListener.class);
		
		// 指定父应用上下文
		sonApplicationContext.setParent(parentApplicationContext);
		
		// 刷新父应用上下文
		parentApplicationContext.refresh();
		// 刷新子应用上下文
		// 子应用上下文会包含父应用上下文，会将自己的id添加到父应用上下文的id，刷新子应用上下文也会刷新父应用上下文
		sonApplicationContext.refresh();
		
		parentApplicationContext.close();
		sonApplicationContext.close();
	}
}