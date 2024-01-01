package CustomContextRefreshedEventListener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author anthony
 * @since 2024/1/1 11:03
 */
@Slf4j
public class HierarchicalSpringEventListener implements ApplicationListener<ContextRefreshedEvent> {
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		log.info("应用上下文id={}，事件：{}", event.getApplicationContext().getId(), event);
	}
}