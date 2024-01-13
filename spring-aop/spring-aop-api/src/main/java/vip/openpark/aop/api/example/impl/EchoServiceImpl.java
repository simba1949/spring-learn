package vip.openpark.aop.api.example.impl;

import lombok.extern.slf4j.Slf4j;
import vip.openpark.aop.api.example.IEchoService;

/**
 * @author anthony
 * @since 2024/1/13 18:56
 */
@Slf4j
public class EchoServiceImpl implements IEchoService {
	@Override
	public void echo(String msg) {
		log.info("EchoServiceImpl#echo execute");
	}
}