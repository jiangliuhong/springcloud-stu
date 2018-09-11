package pers.jarome.scs.act;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableEurekaClient
@EnableTransactionManagement
@SpringBootApplication
@EnableAutoConfiguration(exclude =  SecurityAutoConfiguration.class)
public class ActApplication {
    public static void main(String[] args) {
        SpringApplication.run(ActApplication.class);
    }
}
