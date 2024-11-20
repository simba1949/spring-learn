package vip.openpark.spring.el.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author anthony
 * @version 2024-11-20
 * @since 2024-11-20 14:41
 */
@Data
public class User {
	private String name;
	private LocalDateTime birthday;
	private Boolean isAdmin;

	private List<Role> roles;
	private Set<String> emails;
	private Map<String, String> addresses;
}