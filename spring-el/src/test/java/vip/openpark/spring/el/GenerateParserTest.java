package vip.openpark.spring.el;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.List;
import java.util.Map;

/**
 * @author anthony
 * @version 2024-11-20
 * @since 2024-11-20 15:40
 */
@Slf4j
public class GenerateParserTest {
	@Test
	public void generateTest() {
		ExpressionParser parser = new SpelExpressionParser();
		// List
		Expression exp0 = parser.parseExpression("{1,2,3,4}");
		log.info("exp0:{}", exp0.getValue(List.class)); // [1, 2, 3, 4]

		// List<List>
		Expression exp1 = parser.parseExpression("{{'a','b'},{'x','y'}}");
		log.info("exp1:{}", exp1.getValue(List.class)); // [[a, b], [x, y]]

		// map
		Expression exp2 = parser.parseExpression("{name:{first:'Nikola',last:'Tesla'},dob:{day:10,month:'July',year:1856}}");
		log.info("exp2:{}", exp2.getValue(Map.class)); // {name={first=Nikola, last=Tesla}, dob={day=10, month=July, year=1856}}

		// 数组
		Expression exp3 = parser.parseExpression("new int[] {1, 2, 3}");
		log.info("exp3:{}", exp3.getValue(int[].class)); // [1, 2, 3]
	}
}