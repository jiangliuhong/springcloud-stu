package top.jiangliuhong.scs.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;

/**
 *
 * AdminApplication
 * @description 管理中心
 * @author jiangliuhong
 * @date 2020/7/1 11:22
 * @version 1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@NacosPropertySource(dataId = "example", autoRefreshed = true)
public class BaseApplication {

    public static void main(String[] args) {
        SpringApplication.run( BaseApplication.class, args );
    }
}
