package vip.openpark.bean.ioc.xml.bean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author anthony
 * @version 2023/12/18 16:40
 */
@Slf4j
@Data
public class UserBeanWithXmlGC implements Closeable {
	private Long id;
	private String name;
	private Short age;

	/**
	 * JDK9（含）之前须有finalize方法
	 *
	 * @throws Throwable 异常
	 */
	@Override
	protected void finalize() throws Throwable {
		log.info("finalize 销毁中");
	}

	/**
	 * JDK9（含）之后，需要实现 Closeable ，重写 close 方法
	 *
	 * @throws IOException 异常
	 */
	@Override
	public void close() throws IOException {
		log.info("close 销毁中");
	}
}