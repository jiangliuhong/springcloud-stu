package top.jiangliuhong.scs.gateway.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import top.jiangliuhong.scs.gateway.service.RouteService;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RouteRunner implements CommandLineRunner {
    @Autowired
    private RouteService routeService;

    @Override
    public void run(String... args) throws Exception {
        routeService.loadRoute();
    }
}
