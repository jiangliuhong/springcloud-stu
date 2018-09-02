package pers.jarome.scs.urp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * UrpApplication
 *
 * @author jiangliuhong
 * @date 2018/9/2 13:54
 */
@SpringBootApplication
@EnableEurekaClient
@EnableTransactionManagement
@MapperScan(value = "pers.jarome.scs.urp.core.dao")
public class UrpApplication {
    public static void main(String[] args) {
        SpringApplication.run(UrpApplication.class);
    }
}
