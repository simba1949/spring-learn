package vip.openpark.aop.annotation.example;

import org.springframework.stereotype.Component;

/**
 * @author anthony
 * @version 2023/11/15 22:19
 */
@Component
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int i, int j) {
        return i + j;
    }

    @Override
    public int minus(int i, int j) {
        return i - j;
    }

    @Override
    public int mul(int i, int j) {
        return i * j;
    }

    @Override
    public int div(int i, int j) {
        return i / j;
    }
}