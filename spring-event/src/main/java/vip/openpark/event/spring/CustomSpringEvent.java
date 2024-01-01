package vip.openpark.event.spring;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * @author anthony
 * @since 2024/1/1 11:32
 */
@Getter
@Setter
public class CustomSpringEvent extends ApplicationEvent {
	private static final long serialVersionUID = -9067880890127779252L;
	
	private String payload;
	
	public CustomSpringEvent(Object source) {
		super(source);
	}
}