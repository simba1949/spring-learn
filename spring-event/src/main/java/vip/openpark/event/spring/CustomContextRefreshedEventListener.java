package vip.openpark.event.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author anthony
 * @since 2024/1/1 11:06
 */
@Slf4j
public class CustomContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
	
	private static Set<ApplicationContextEvent> events = new LinkedHashSet<>();
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// 这里通过去重对重复事件进行过滤
		if (events.add(event)) {
			log.info("应用上下文id={}，事件：{}", event.getApplicationContext().getId(), event);
		}
	}
}