package vip.openpark.data.bind;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.validation.DataBinder;
import vip.openpark.data.bind.common.User;

import java.util.HashMap;

/**
 * @author anthony
 * @since 2023/12/30 16:46
 */
@Slf4j
public class DataBinderTest {
	@Test
	public void dataBinderTest() {
		// 创建User对象
		User user = new User();
		// 创建DataBinder对象
		DataBinder dataBinder = new DataBinder(user, "user");
		// 设置数据
		HashMap<String, Object> source = new HashMap<>();
		source.put("id", 1L);
		source.put("name", "anthony");
		MutablePropertyValues propertyValues = new MutablePropertyValues(source);
		// 绑定数据
		dataBinder.bind(propertyValues);

		log.info("{}", user);
	}
}