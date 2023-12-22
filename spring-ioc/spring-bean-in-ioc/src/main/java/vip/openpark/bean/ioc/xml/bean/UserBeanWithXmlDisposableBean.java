package vip.openpark.bean.ioc.xml.bean;

import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;

/**
 * @author anthony
 * @version 2023/12/22 17:54
 */
@Slf4j
public class UserBeanWithXmlDisposableBean implements DisposableBean {
	
	@PreDestroy
	public void customPreDestroy() {
		log.info("customPreDestroy");
	}
	
	@Override
	public void destroy() throws Exception {
		log.info("destroy");
	}
	
	public void customDestroy() {
		log.info("customDestroy");
	}
}