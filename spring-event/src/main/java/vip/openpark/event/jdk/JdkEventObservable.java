package vip.openpark.event.jdk;

import java.util.Observable;

/**
 * @author anthony
 * @since 2023/12/31 17:45
 */
public class JdkEventObservable extends Observable {
	@Override
	public void notifyObservers(Object arg) {
		// 通知对象已经更改
		setChanged();
		super.notifyObservers(arg);
		// 通过对象已经更改完成
		clearChanged();
	}
}