package top.jiangliuhong.scs.gateway.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import top.jiangliuhong.scs.gateway.service.RouteService;

/**
 * RouteRunner <br/>
 *
 * @author jiangliuhong
 * @date 2020/10/8 2:01 下午
 * @version 1.0.0
 */
@Slf4j
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RouteRunner implements CommandLineRunner {
    @Autowired
    private RouteService routeService;

    @Override
    public void run(String... args) throws Exception {
        try {
            routeService.loadRoute();
        } catch (Exception e) {
            log.error("加载动态路由失败", e);
        }
    }
}
