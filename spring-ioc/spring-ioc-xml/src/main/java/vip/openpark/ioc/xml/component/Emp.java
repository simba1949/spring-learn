package vip.openpark.ioc.xml.component;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author anthony
 * @version 2023/11/14 18:38
 */
@Slf4j
@Data
public class Emp {
    private Dept dept;

    private String name;
    private String age;
}