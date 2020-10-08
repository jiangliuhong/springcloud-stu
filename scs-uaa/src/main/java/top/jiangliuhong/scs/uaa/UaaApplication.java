package top.jiangliuhong.scs.uaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * UaaApplication <br/>
 *
 * @author jiangliuhong
 * @date 2020/10/8 10:39 上午
 * @version 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UaaApplication {

    public static void main(String[] args) {
        SpringApplication.run(UaaApplication.class);
    }
}
