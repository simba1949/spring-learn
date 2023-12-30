package vip.openpark.validation.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.StaticMessageSource;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.Locale;

/**
 * @author anthony
 * @since 2023/12/30 13:26
 */
@Slf4j
public class UserTest {

	@Test
	public void validateTest() {
		// 准备校验的对象
		User user = new User();
		user.setName(null);
		user.setId(null);

		// 1.选择 Errors ——> BeanPropertyBindingResult
		Errors errors = new BeanPropertyBindingResult(user, "user");
		// 2.调用 reject 或者 rejectValue
		// reject 生成 ObjectError
		// reject 生成 FieldError
		errors.reject("user.properties.not.null");
		errors.rejectValue("name", "name.not.null", "name is not null");
		errors.rejectValue("id", "id.not.null", "id is not null");

		// 3.获取 Errors 中的 ObjectError 和 FieldError
		List<ObjectError> globalErrors = errors.getGlobalErrors();
		List<FieldError> fieldErrors = errors.getFieldErrors();
		List<ObjectError> allErrors = errors.getAllErrors();

		// 4.通过 ObjectError 和 FieldError 中的 code 和 args 来关联 MessageSource 实现
		StaticMessageSource staticMessageSource = new StaticMessageSource();
		staticMessageSource.addMessage("user.properties.not.null", Locale.ENGLISH, "all field of User not null");
		staticMessageSource.addMessage("user.properties.not.null", Locale.CHINA, "用户所有属性不能为空");
		staticMessageSource.addMessage("id.not.null", Locale.ENGLISH, "the id of User must not be null.");
		staticMessageSource.addMessage("id.not.null", Locale.CHINA, "用户的id不能为空");
		staticMessageSource.addMessage("name.not.null", Locale.ENGLISH, "the id of User must not be null.");
		staticMessageSource.addMessage("name.not.null", Locale.CHINA, "用户的名称不能为空");

		// 打印日志信息
		for (ObjectError error : allErrors) {
			String message = staticMessageSource.getMessage(error.getCode(), error.getArguments(), Locale.ENGLISH);
			log.info("message: {}", message);
		}
	}
}