package vip.openpark.validation.common;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author anthony
 * @since 2023/12/30 15:35
 */
@Data
public class UserWithHibernateValidator {
	@NotNull(message = "id不能为空")
	private Long id;
	@NotBlank(message = "name不能为空")
	private String name;
}