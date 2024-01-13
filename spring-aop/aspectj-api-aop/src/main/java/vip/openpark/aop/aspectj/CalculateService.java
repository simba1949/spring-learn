package vip.openpark.aop.aspectj;

/**
 * 计算服务
 *
 * @author anthony
 * @since 2024/1/13 13:36
 */
public class CalculateService {
	
	public int add(int i, int j) {
		return i + j;
	}
	
	public int minus(int i, int j) {
		return i - j;
	}
	
	public int mul(int i, int j) {
		return i * j;
	}
	
	public int div(int i, int j) {
		return i / j;
	}
}