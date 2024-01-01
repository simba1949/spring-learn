package vip.openpark.event.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * {@link ApplicationListener<>} 这里可以指定具体事件的类型
 * 1.实现 ApplicationListener 接口，可以指定事件类型，并重写 onApplicationEvent 方法
 * 2.注册到 spring 容器中
 *
 * @author anthony
 * @since 2024/1/1 10:28
 */
@Slf4j
public class CustomApplicationContextListener implements ApplicationListener<ApplicationEvent> {
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		log.info("自定义 spring 事件监听器，监听事件 {}", event);
	}
}