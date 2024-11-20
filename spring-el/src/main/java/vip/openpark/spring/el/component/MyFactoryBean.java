package vip.openpark.spring.el.component;

import lombok.Data;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author anthony
 * @version 2024-11-20
 * @since 2024-11-20 16:52
 */
@Component
public class MyFactoryBean implements FactoryBean<MyFactoryBean.House> {
	private final House house = new House("myHouse");

	@Override
	public House getObject() throws Exception {
		return house;
	}

	@Override
	public Class<?> getObjectType() {
		return House.class;
	}

	@Data
	public static class House {
		private String name;

		private House(String name) {
			this.name = name;
		}
	}
}