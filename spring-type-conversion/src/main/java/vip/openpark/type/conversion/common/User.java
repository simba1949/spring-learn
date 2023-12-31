package vip.openpark.type.conversion.common;

import lombok.Data;

import java.util.Date;

/**
 * @author anthony
 * @since 2023/12/31 10:03
 */
@Data
public class User {
	private Long id;
	private String name;

	private Date birthday;
}