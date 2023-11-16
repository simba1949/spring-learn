package vip.openpark.transaction.xml.repository;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author anthony
 * @version 2023/11/16 22:01
 */
@SpringJUnitConfig(locations = "classpath:bean.xml")
public class UserRepositoryTest {

    @Resource
    private UserRepository userRepository;

    @Test
    public void deleteTwoTableTest() {
        userRepository.deleteTwoTable();
    }

    @Test
    public void deleteTwoTableWithExTest() {
        userRepository.deleteTwoTableWithEx();
    }

    @Test
    public void insertTwoTableTest() {
        userRepository.insertTwoTable();
    }

    @Test
    public void insertTwoTableWithExTest() {
        userRepository.insertTwoTableWithEx();
    }
}