package vip.openpark.aop.annotation.event.theory;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

/**
 * @author anthony
 * @since 2024/1/21 10:05
 */
@Getter
@Setter
@ToString(callSuper = true)
public class ShowCallEvent<T> extends ApplicationEvent {
	private static final long serialVersionUID = -6084070694921735657L;
	
	private T payload;
	
	public ShowCallEvent(Object source) {
		super(source);
	}
}