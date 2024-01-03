package vip.openpark.annotation.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author anthony
 * @version 2024/1/3 12:41
 */
public class OddCondition implements Condition {
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		if (context.getEnvironment().acceptsProfiles("odd")) {
			return true;
		}
		return false;
	}
}