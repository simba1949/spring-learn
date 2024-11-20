package vip.openpark.spring.el.domain;

import lombok.Data;

import java.util.List;

/**
 * @author anthony
 * @version 2024-11-20
 * @since 2024-11-20 14:41
 */
@Data
public class Role {
	private String name;
	private String description;
	private List<Permission> permissions;
}
