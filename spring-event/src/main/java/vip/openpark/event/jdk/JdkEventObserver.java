package vip.openpark.event.jdk;

import lombok.extern.slf4j.Slf4j;

import java.util.Observable;
import java.util.Observer;

/**
 * @author anthony
 * @since 2023/12/31 17:40
 */
@Slf4j
public class JdkEventObserver implements Observer {
	/**
	 * 更新观察者。
	 *
	 * @param observable   可观察的对象。
	 * @param arg 传递给 {@code notifyObservers} 方法的参数。
	 */
	@Override
	public void update(Observable observable, Object arg) {
		log.info("jdk event observer update");
		log.info("observable:{}, arg:{}", observable, arg);
	}
}
