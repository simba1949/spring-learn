package vip.openpark.validation.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import vip.openpark.validation.common.User;

/**
 * @author anthony
 * @since 2023/12/30 14:25
 */
public class CustomValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (target instanceof User) {
			User user = (User) target;
			// 使用 ValidationUtils 工具类
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.not.null", "name不能为空");
			// 使用 Errors
			if (user.getId() == null || user.getId() < 1) {
				errors.rejectValue("id", "id.not.null", "id不能为空");
			}
		}
	}
}