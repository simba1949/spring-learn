package vip.openpark.validation.validate;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import vip.openpark.validation.common.User;

/**
 * @author anthony
 * @since 2023/12/30 14:36
 */
@Slf4j
public class CustomValidatorTest {

	@Test
	public void testValidate() {
		// 1. 实例化自定义校验器
		CustomValidator customValidator = new CustomValidator();
		// 2. 校验对象是否支持校验
		User user = new User();
		log.info("user 对象是否支持 validator = {}", customValidator.supports(user.getClass()));

		// 3. 校验对象
		Errors errors = new BeanPropertyBindingResult(user, "user");
		customValidator.validate(user, errors);
		// 4. 打印错误信息
		if (errors.hasErrors()) {
			for (ObjectError allError : errors.getAllErrors()) {
				log.info("错误信息 = {}", allError.getDefaultMessage());
			}
		}
	}
}