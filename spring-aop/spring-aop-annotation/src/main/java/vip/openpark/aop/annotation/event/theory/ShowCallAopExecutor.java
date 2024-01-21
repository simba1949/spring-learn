package vip.openpark.aop.annotation.event.theory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * @author anthony
 * @since 2024/1/21 10:12
 */
@Slf4j
public class ShowCallAopExecutor {
	public void execute() { // join point 需要使用 Pointcut 过滤
		log.info("ShowCallAopExecutor 执行了");
	}
	
}