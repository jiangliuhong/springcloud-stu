package top.jiangliuhong.scs.gateway.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.jiangliuhong.scs.gateway.module.Route;
import top.jiangliuhong.scs.gateway.service.RouteService;

@RestController
@RequestMapping("/api/route")
public class RouteApi {

    @Autowired
    private RouteService routeService;

    @GetMapping("")
    public ResponseEntity<List<Route>> getRoute() {
        return ResponseEntity.ok(routeService.getRoutes());
    }

    @GetMapping("/refresh")
    public ResponseEntity<String> refresh() {
        routeService.loadRoute();
        return ResponseEntity.ok("refresh ok");
    }
}
