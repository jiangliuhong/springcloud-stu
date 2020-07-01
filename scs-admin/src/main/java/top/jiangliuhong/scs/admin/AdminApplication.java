package top.jiangliuhong.scs.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 * AdminApplication
 * @description 管理中心
 * @author jiangliuhong
 * @date 2020/7/1 11:22
 * @version 1.0.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run( AdminApplication.class, args );
    }
}
