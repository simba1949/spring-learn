package vip.openpark.ioc.xml.bean.life;

import lombok.extern.slf4j.Slf4j;

/**
 * @author anthony
 * @version 2023/11/14 20:24
 */
@Slf4j
public class BeanLifeCycle {
    private String name;

    public BeanLifeCycle() {
        log.info("1无参构造方法");
    }

    public void setName(String name) {
        log.info("2setter属性值");
        this.name = name;
    }

    public void init() {
        log.info("4.bean对象初始化了");
    }

    public void destroy() {
        log.info("7.bean对象被销毁了");
    }
}