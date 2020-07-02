package top.jiangliuhong.scs.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * RouteConfig
 * 
 * @description 路由配置
 * @author jiangliuhong
 * @date 2020/7/1 14:04
 * @version 1.0.0
 */
//@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes().route("path_route", r -> r.path("/about").uri("http://ityouknow.com")).build();
    }
}
