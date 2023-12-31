package vip.openpark.event.jdk;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author anthony
 * @since 2023/12/31 17:42
 */
@Slf4j
public class JdkEventObserverTest {
	
	@Test
	public void sendEvent() {
		JdkEventObservable observable = new JdkEventObservable();
		// 添加观察者
		observable.addObserver(new JdkEventObserver());
		// 发送事件
		observable.notifyObservers("Hello World");
	}
}