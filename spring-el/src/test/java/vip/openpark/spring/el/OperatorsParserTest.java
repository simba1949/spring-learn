package vip.openpark.spring.el;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @author anthony
 * @version 2024-11-20
 * @since 2024-11-20 15:52
 */
@Slf4j
public class OperatorsParserTest {
	@Test
	public void operatorsTest() {
		ExpressionParser parser = new SpelExpressionParser();

		// Relational Operators
		// lt (<) gt (>) le (<=) ge (>=) eq (==) ne (!=)
		Expression exp0 = parser.parseExpression("2 == 2");
		log.info("2 == 2:{}", exp0.getValue(Boolean.class)); // true
		Expression exp1 = parser.parseExpression("2 ne 2");
		log.info("2 ne 2:{}", exp1.getValue(Boolean.class)); // false

		// between, instanceof, matches
		Expression exp2 = parser.parseExpression("1 between {1, 5}");
		log.info("1 between {1, 5}:{}", exp2.getValue(Boolean.class)); // true
		Expression exp3 = parser.parseExpression("123 instanceof T(Integer)");
		log.info("123 instanceof T(Integer):{}", exp3.getValue(Boolean.class)); // true
		Expression exp4 = parser.parseExpression("'5.00' matches '^-?\\d+(\\.\\d{2})?$'");
		log.info("'5.00' matches '^-?\\d+(\\.\\d{2})?$':{}", exp4.getValue(Boolean.class)); // true

		// Logical Operators
		// and (&&) or (||) not (!)
		Expression exp5 = parser.parseExpression("true and false");
		log.info("true and false:{}", exp5.getValue(Boolean.class)); // false

		// String Operators
		// 字符串连接 +，
		// 字符串减少一个字符 -，用于包含单个字符的字符串，使用 ASCII 码做减法
		// 字符串重复次数 *
		Expression exp6 = parser.parseExpression("'hello ' + 'world'");
		log.info("'hello' + 'world':{}", exp6.getValue(String.class)); // hello world
		Expression exp7 = parser.parseExpression("'b' - 1"); // a
		log.info("'hello ' - 'o':{}", exp7.getValue(String.class)); // hell
		Expression exp8 = parser.parseExpression("'hello ' * 3");
		log.info("'hello ' * 3:{}", exp8.getValue(String.class)); // hello hello hello

		// Mathematical Operators
		// addition (+) subtraction (-) increment (++) decrement (--)
		// multiplication (*) division (/) modulus (%)
		// exponential power (^) div (/) mod (%)
		Expression exp9 = parser.parseExpression("1 + 2");
		log.info("1 + 2:{}", exp9.getValue(Integer.class)); // 3
		Expression exp10 = parser.parseExpression("1 - 2");
		log.info("1 - 2:{}", exp10.getValue(Integer.class)); // -1
		Expression exp11 = parser.parseExpression("1 * 2");
		log.info("1 * 2:{}", exp11.getValue(Integer.class)); // 2
	}
}