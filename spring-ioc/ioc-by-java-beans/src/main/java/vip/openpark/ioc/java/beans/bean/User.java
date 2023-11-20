package vip.openpark.ioc.java.beans.bean;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author anthony
 * @version 2023/11/20 21:25
 */
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = -1801692337646826067L;

    private Long id;
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
