package vip.openpark.event.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author anthony
 * @since 2024/1/1 10:02
 */
@Slf4j
@Component
public class ApplicationListenerByAnnotation {
	/**
	 * ApplicationEvent
	 *
	 * @param event {@link  ApplicationEvent}
	 */
	@EventListener
	public void onEvent(ApplicationEvent event) {
		log.info("注解方式：接收到 ApplicationEvent 事件：{}", event);
	}
	
	/**
	 * ApplicationContextEvent
	 * 会监听到以下的事件：
	 * {@link ContextRefreshedEvent}、
	 * {@link ContextStartedEvent}、
	 * {@link ContextStoppedEvent}、
	 * {@link ContextClosedEvent}
	 *
	 * @param event {@link  ApplicationContextEvent}
	 */
	@EventListener
	public void onEvent(ApplicationContextEvent event) {
		log.info("注解方式：接收到 ApplicationContextEvent 事件：{}", event);
	}
	
	@EventListener
	@Async
	public void onEventAsync(ApplicationContextEvent event) {
		log.info("注解方式（异步）：接收到 ApplicationContextEvent 事件：{}", event);
	}
	
	/**
	 * 监听单一类型的事件 {@link ContextRefreshedEvent}
	 *
	 * @param event {@link  ContextRefreshedEvent}
	 */
	@EventListener
	public void onEvent(ContextRefreshedEvent event) {
		log.info("注解方式：接收到 ContextRefreshedEvent 事件：{}", event);
	}
	
	/**
	 * 监听单一类型的事件 {@link ContextStartedEvent}
	 *
	 * @param event {@link  ContextStartedEvent}
	 */
	@EventListener
	public void onEvent(ContextStartedEvent event) {
		log.info("注解方式：接收到 ContextStartedEvent 事件：{}", event);
	}
	
	/**
	 * 监听单一类型的事件 {@link ContextStoppedEvent}
	 *
	 * @param event {@link  ContextStoppedEvent}
	 */
	@EventListener
	public void onEvent(ContextStoppedEvent event) {
		log.info("注解方式：接收到 ContextStoppedEvent 事件：{}", event);
	}
	
	/**
	 * 监听单一类型的事件 {@link ContextClosedEvent}
	 *
	 * @param event {@link  ContextClosedEvent}
	 */
	@EventListener
	public void onEvent(ContextClosedEvent event) {
		log.info("注解方式：接收到 ContextClosedEvent 事件：{}", event);
	}
}