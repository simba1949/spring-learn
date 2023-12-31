package vip.openpark.type.conversion.common;

import lombok.Data;

import java.util.List;

/**
 * @author anthony
 * @since 2023/12/31 16:12
 */
@Data
public class User4GenericType<E> {
	private Long id;
	private String name;
	private E element;
	private List<E> elements;
	private List<String> strList;
}