package vip.openpark.spring.el;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author anthony
 * @version 2024-11-20
 * @since 2024-11-20 14:31
 */
@Slf4j
public class BasicParserTest {

	@Test
	public void basicParserTest(){
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp0 = parser.parseExpression("'Hello World'");
		log.info("'Hello World' : {}", (String) exp0.getValue()); // Hello World

		Expression exp1 = parser.parseExpression("'Hello World'.concat('!')");
		log.info("\"'Hello World'.concat('!')\" : {}", (String) exp1.getValue()); // Hello World!

		// invokes 'getBytes()'
		Expression exp2 = parser.parseExpression("'Hello World'.bytes");
		log.info("\"'Hello World'.bytes\" : {}", (byte[]) exp2.getValue());

		// invokes 'getBytes().length'
		Expression exp3 = parser.parseExpression("'Hello World'.bytes.length");
		log.info("\"'Hello World'.bytes.length\": {}", (Integer) exp3.getValue()); // 11

		// invokes 'new String(...).toUpperCase()'
		Expression exp4 = parser.parseExpression("new String('hello world').toUpperCase()");
		log.info("\"new String('hello world').toUpperCase()\": {}", (String) exp4.getValue());
	}
}