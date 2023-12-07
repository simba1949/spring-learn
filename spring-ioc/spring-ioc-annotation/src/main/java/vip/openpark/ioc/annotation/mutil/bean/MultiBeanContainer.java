package vip.openpark.ioc.annotation.mutil.bean;

import jakarta.annotation.Resource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author anthony
 * @version 2023/12/7 21:46
 */
@Data
@Component
public class MultiBeanContainer {
	@Resource
	private Collection<MultiBean> allMultiBeans;

	@Resource
	@Qualifier("beanGroup")
	private Collection<MultiBean> beanGroups;
}