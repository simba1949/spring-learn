package vip.openpark.spring.el;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import vip.openpark.spring.el.domain.Role;
import vip.openpark.spring.el.domain.User;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author anthony
 * @version 2024-11-20
 * @since 2024-11-20 14:40
 */
@Slf4j
public class ObjectParserTest {
	@Test
	public void springElParserTest() {
		ExpressionParser parser = new SpelExpressionParser();

		User user = getUser();

		Expression exp0 = parser.parseExpression("name");
		String name = exp0.getValue(user, String.class);
		log.info("name: {}", name); // anthony

		Expression exp1 = parser.parseExpression("isAdmin");
		Boolean isAdmin = exp1.getValue(user, Boolean.class);
		log.info("isAdmin: {}", isAdmin); // null

		// 数值或者List 集合，可通过索引获取
		// user.role[0] 获取第一个角色
		Expression exp2 = parser.parseExpression("roles[0]");
		log.info("roles[0]: {}", exp2.getValue(user, Role.class)); // admin

		// 对于任何其他类型的Collection，将通过使用其Iterator遍历集合并返回遇到的第n个元素来访问第n个元素。
		Expression exp3 = parser.parseExpression("emails[0]");
		log.info("emails[0]: {}", exp3.getValue(user));

		// 通过索引获取字符串第几个字符
		// user.role[0].name[0] 获取第一个角色名字的第一个字符
		Expression exp4 = parser.parseExpression("roles[0].name[0]");
		log.info("roles[0].name[0]: {}", exp4.getValue(user)); // a

		// map，通过key获取value
		Expression exp5 = parser.parseExpression("addresses['china']");
		log.info("addresses['china']: {}", exp5.getValue(user));

		// 对于对象类型，可通过#root[属性名]获取其属性
		Expression exp6 = parser.parseExpression("#root['birthday']");
		log.info("birthday: {}", exp6.getValue(user, LocalDateTime.class));

		// 方法调用
		Expression exp7 = parser.parseExpression("name.toUpperCase()");
		log.info("name.toUpperCase(): {}", exp7.getValue(user, String.class)); // ANTHONY
	}

	private User getUser() {
		User user = new User();
		user.setName("anthony");
		user.setBirthday(LocalDateTime.of(2024, 11, 20, 14, 40));

		Role role = new Role();
		role.setName("admin");
		role.setDescription("管理员");
		user.setRoles(Collections.singletonList(role));

		Set<String> set = Stream.of("dev@openpark.vip", "anthony@openpark.vip", "test@openpark.vip").collect(Collectors.toSet());
		user.setEmails(set);

		Map<String, String> map = new HashMap<>();
		map.put("china", "中国");
		map.put("us", "美国");
		user.setAddresses(map);
		return user;
	}
}