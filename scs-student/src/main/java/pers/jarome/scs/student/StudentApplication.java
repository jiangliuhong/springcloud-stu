package pers.jarome.scs.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * StudentApplication
 *
 * @author jiangliuhong
 * @date 2018/9/2 13:51
 */
@SpringBootApplication
@EnableEurekaClient
public class StudentApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class);
    }
}
