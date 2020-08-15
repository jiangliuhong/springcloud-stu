package top.jiangliuhong.scs.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 * AdminApplication
 * 
 * @description 管理中心
 * @author jiangliuhong
 * @date 2020/7/1 11:22
 * @version 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@tk.mybatis.spring.annotation.MapperScan(basePackages = "top.jiangliuhong.scs")
public class BaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
    }
}
