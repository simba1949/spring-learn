package vip.openpark.spring.el;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author anthony
 * @version 2024-11-20
 * @since 2024-11-20 16:08
 */
@Slf4j
public class TypeParserTest {

	@Test
	public void typeParserTest() {
		ExpressionParser parser = new SpelExpressionParser();

		Expression exp0 = parser.parseExpression("T(java.util.Date)");
		log.info("T(java.util.Date):{}", exp0.getValue(Class.class)); // class java.util.Date
	}
}