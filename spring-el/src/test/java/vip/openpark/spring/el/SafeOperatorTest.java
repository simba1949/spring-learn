package vip.openpark.spring.el;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import vip.openpark.spring.el.domain.Role;
import vip.openpark.spring.el.domain.User;

import java.util.Collections;
import java.util.List;

/**
 * @author anthony
 * @version 2024-11-20
 * @since 2024-11-20 17:08
 */
@Slf4j
public class SafeOperatorTest {
	@Test
	public void safeOperatorTest() {
		ExpressionParser parser = new SpelExpressionParser();

		// 三元操作
		Expression exp0 = parser.parseExpression("false ? 'trueExp' : 'falseExp'");
		log.info("[false ? 'trueExp' : 'falseExp'] 结果:{}", exp0.getValue(String.class));

		// The Elvis Operator
		// #root?:'Unknown' 等同于 #root != null ? #root : 'Unknown'
		String src = null;
		Expression exp1 = parser.parseExpression("#root != null ? #root : 'Unknown'");
		log.info("[#root != null ? #root : 'Unknown'] 结果:{}", exp1.getValue(src)); // Unknown
		Expression exp2 = parser.parseExpression("#root?:'Unknown'");
		log.info("[#root?:'Unknown'] 结果:{}", exp2.getValue(src)); // Unknown

		// Safe Navigation Operator 可以避免 NPE 的问题，同样适用数组、字符串、集合（List、Set、Map）、对象等
		User user = null;
		Expression exp3 = parser.parseExpression("#root != null ? #root.name : null");
		log.info("[#root != null ? #root.name : null] 结果:{}", exp3.getValue(user));
		Expression exp4 = parser.parseExpression("#root?.name");
		log.info("[#root?.name] 结果:{}", exp4.getValue(user));

		// null-safe selection: ?.?
		// null-safe select first: ?.^
		// null-safe select last: ?.$
		// null-safe projection: ?.!
		User user1 = new User();
		Role role = new Role();
		role.setName("admin");
		role.setDescription("管理员");
		user1.setRoles(Collections.singletonList(role));
		StandardEvaluationContext context = new StandardEvaluationContext(user1);

		Expression exp5 = parser.parseExpression("roles?.?[name == 'admin']");
		log.info("[roles?.?[name=='admin']] 结果:{}", exp5.getValue(context));

		Expression exp6 = parser.parseExpression("roles?.^[name == 'dev']");
		log.info("[roles?.^[name == 'dev']] 结果:{}", exp6.getValue(context, Role.class));

		Expression exp7 = parser.parseExpression("roles?.$[name == 'fat']");
		log.info("[roles?.$[name == 'fat']] 结果:{}", exp7.getValue(context, Role.class));
	}
}