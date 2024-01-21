package vip.openpark.aop.annotation.event.theory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author anthony
 * @since 2024/1/21 10:37
 */
@Slf4j
@Component
public class ShowCallListener {
	@EventListener(ShowCallEvent.class)
	public void handler(ShowCallEvent event) {
		log.info("显示处理 spring 事件监听事件 {}", event);
	}
}