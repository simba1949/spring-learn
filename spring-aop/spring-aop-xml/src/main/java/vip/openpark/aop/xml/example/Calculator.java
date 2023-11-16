package vip.openpark.aop.xml.example;

/**
 * @author anthony
 * @version 2023/11/15 22:19
 */
public interface Calculator {

    /**
     * 加法
     * @param i
     * @param j
     * @return
     */
    int add(int i, int j);

    /**
     * 减法
     * @param i
     * @param j
     * @return
     */
    int minus(int i, int j);

    /**
     * 乘法
     * @param i
     * @param j
     * @return
     */
    int mul(int i, int j);

    /**
     * 除法
     * @param i
     * @param j
     * @return
     */
    int div(int i, int j);
}
