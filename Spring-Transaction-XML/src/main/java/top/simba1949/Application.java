package top.simba1949;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author simba1949@outlook.com
 * @date 2018/8/25 8:01
 */
@SpringBootApplication
@MapperScan(basePackages = "top.simba1949.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
