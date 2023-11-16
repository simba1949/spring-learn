package vip.openpark.transaction.annotation.repository;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author anthony
 * @version 2023/11/16 21:51
 */
@Slf4j
@Repository
public class UserRepository {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void deleteTwoTable() {
        String deleteUserSql = "DELETE FROM user WHERE id = ?";
        int userAffectRow = jdbcTemplate.update(deleteUserSql, 9);
        log.info("影响行数：{}", userAffectRow);

        String deleteRoleSql = "DELETE FROM role WHERE id = ?";
        int roleAffectRow = jdbcTemplate.update(deleteRoleSql, 9);
        log.info("影响行数：{}", roleAffectRow);
    }

    @Transactional
    public void deleteTwoTableWithEx() {
        String deleteUserSql = "DELETE FROM user WHERE id = ?";
        int userAffectRow = jdbcTemplate.update(deleteUserSql, 9);
        log.info("影响行数：{}", userAffectRow);

        int i = 1/0;

        String deleteRoleSql = "DELETE FROM role WHERE id = ?";
        int roleAffectRow = jdbcTemplate.update(deleteRoleSql, 9);
        log.info("影响行数：{}", roleAffectRow);
    }

    @Transactional
    public void insertTwoTable() {
        String insertUserSql = "INSERT INTO user(id, code, username, password) VALUES(?, ?, ?, ?)";
        int userAffectRow = jdbcTemplate.update(insertUserSql, 9, "W-U1", "WU1", "WU1");
        log.info("影响行数：{}", userAffectRow);

        String insertRoleSql = "INSERT INTO role(id, code, name) VALUES(?, ?, ?)";
        int affectRow = jdbcTemplate.update(insertRoleSql, 9, "W-R1", "WR1");
        log.info("影响行数：{}", affectRow);
    }

    @Transactional
    public void insertTwoTableWithEx() {
        String insertUserSql = "INSERT INTO user(id, code, username, password) VALUES(?, ?, ?, ?)";
        int userAffectRow = jdbcTemplate.update(insertUserSql, 9, "W-U1", "WU1", "WU1");
        log.info("影响行数：{}", userAffectRow);

        int i = 1/0;

        String insertRoleSql = "INSERT INTO role(id, code, name) VALUES(?, ?, ?)";
        int affectRow = jdbcTemplate.update(insertRoleSql, 9, "W-R1", "WR1");
        log.info("影响行数：{}", affectRow);
    }
}