package pers.jarome.scs.student;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * StudentApplication
 *
 * @author jiangliuhong
 * @date 2018/9/2 13:51
 */
@SpringBootApplication
@EnableEurekaClient
@EnableTransactionManagement
@MapperScan(value = "pers.jarome.scs.student.core.dao")
public class StudentApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class);
    }
}
