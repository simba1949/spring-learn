package vip.openpark.transaction.jdbc.domain;

import com.alibaba.fastjson2.JSON;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

/**
 * @author anthony
 * @version 2023/11/16 20:12
 */
@Slf4j
@SpringJUnitConfig(locations = "classpath:bean.xml")
public class UserTest {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Test
    public void delete() {
        String deleteSql = "DELETE FROM user WHERE id = ?";

        int affectRow = jdbcTemplate.update(deleteSql, 8);
        log.info("影响行数：{}", affectRow);
    }

    @Test
    public void insert() {
        String insertSql = "INSERT INTO user(id, code, username, password) VALUES(?, ?, ?, ?)";

        int affectRow = jdbcTemplate.update(insertSql, 8, "A-1", "A1", "A1");
        log.info("影响行数：{}", affectRow);
    }

    @Test
    public void update() {
        String updateSql = "UPDATE  user SET code=?, username=?, password=? WHERE id = ?";

        int affectRow = jdbcTemplate.update(updateSql, "A-2", "A2", "A2", 8);
        log.info("影响行数：{}", affectRow);
    }

    @Test
    public void selectList() {
        String selectSql = "SELECT * FROM user";

        List<UserDO> userList = jdbcTemplate.query(selectSql, new BeanPropertyRowMapper<>(UserDO.class));
        log.info("{}", JSON.toJSONString(userList));
    }

    @Test
    public void selectOne() {
        String selectSql = "SELECT * FROM user WHERE id=?";

        UserDO user = jdbcTemplate.queryForObject(selectSql, new BeanPropertyRowMapper<>(UserDO.class), 1);
        log.info("{}", JSON.toJSONString(user));
    }
}