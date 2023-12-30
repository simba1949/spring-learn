package vip.openpark.i18n;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author anthony
 * @version 2023/11/19 16:06
 */
@Slf4j
public class JdkI18nTest {

	@Test
	public void jdkI18nChinaTest() {
		// 中国：Locale.CHINA
		// 美国：Locale.US
		ResourceBundle resourceBundle = ResourceBundle.getBundle("jdk", Locale.CHINA);
		String string = resourceBundle.getString("language");
		log.info("language={}", string);
	}

	@Test
	public void jdkI18nUsTest() {
		// 中国：Locale.CHINA
		// 美国：Locale.US
		ResourceBundle resourceBundle = ResourceBundle.getBundle("jdk", Locale.US);
		String string = resourceBundle.getString("language");
		log.info("language={}", string);
	}

	@Test
	public void messageFormat1Test() {
		int planet = 7;
		String event = "a disturbance in the force";
		// 这里的0/1/2表示可变参数的索引，从第一个可变参数开始，索引从0开始
		String format = MessageFormat.format(
			"At {1,time} on {1,date}, there was {2} on planet {0, number, integer}.", planet, new Date(), event);
		log.info("{}", format);
	}

	@Test
	public void messageFormat2Test() {
		int planet = 7;
		String event = "a disturbance in the force";
		// 这里的0/1/2表示可变参数的索引，从第一个可变参数开始，索引从0开始
		MessageFormat messageFormat = new MessageFormat("At {1,time} on {1,date}, there was {2} on planet {0, number, integer}.");
		// 这里可变参数只能比索引入参多，不能少
		String format = messageFormat.format(new Object[]{planet, new Date(), event});
		log.info("{}", format);
	}

	@Test
	public void messageFormatResetTest() {
		int planet = 7;
		String event = "a disturbance in the force";
		// 这里的0/1/2表示可变参数的索引，从第一个可变参数开始，索引从0开始
		MessageFormat messageFormat = new MessageFormat("At {1,time} on {1,date}, there was {2} on planet {0, number, integer}.");
		// 这里可变参数只能比索引入参多，不能少
		String format = messageFormat.format(new Object[]{planet, new Date(), event});
		log.info("format = {}", format);

		messageFormat.setLocale(Locale.ENGLISH);
		String format1 = messageFormat.format(new Object[]{planet, new Date(), event});
		log.info("format1 = {}", format1);

		messageFormat.applyPattern("{0}");
		String format2 = messageFormat.format(new Object[]{"人生得意须尽欢"});
		log.info("format2 = {}", format2);
	}
}