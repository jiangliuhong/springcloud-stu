package pers.jarome.scs.urp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * UrpApplication
 *
 * @author jiangliuhong
 * @date 2018/9/2 13:54
 */
@SpringBootApplication
@EnableEurekaClient
public class UrpApplication {
    public static void main(String[] args) {
        SpringApplication.run(UrpApplication.class);
    }
}
