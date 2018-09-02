package pers.jarome.scs.eureka;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *
 * EurekaApplicaion
 * @author jiangliuhong
 * @date 2018/9/2 10:58
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplicaion {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplicaion.class, args);
    }
}
