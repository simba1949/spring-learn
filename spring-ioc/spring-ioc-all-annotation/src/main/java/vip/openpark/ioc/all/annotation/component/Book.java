package vip.openpark.ioc.all.annotation.component;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author anthony
 * @version 2023/12/6 23:11
 */
@Data
public class Book {
    private String name;
    private BigDecimal price;
}