package vip.openpark.ioc.xml.component;

import lombok.Data;

/**
 * @author anthony
 * @version 2023/11/14 19:55
 */
@Data
public class DBInfo {
    private String driver;
    private String url;
    private String username;
    private String password;
}
