package vip.openpark.event.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;

/**
 * @author anthony
 * @since 2024/1/1 11:35
 */
@Slf4j
public class CustomSpringEventListener implements ApplicationListener<CustomSpringEvent> {
	@Override
	public void onApplicationEvent(CustomSpringEvent event) {
		String payload = event.getPayload();
		log.info("payload={}, event:{}", payload, event);
	}
}