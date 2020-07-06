package top.jiangliuhong.scs.gateway.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.jiangliuhong.scs.gateway.bean.req.RouteQuery;
import top.jiangliuhong.scs.gateway.module.Route;
import top.jiangliuhong.scs.gateway.service.RouteService;

@RestController
@RequestMapping("/api/v1/route")
public class RouteApi {

    @Autowired
    private RouteService routeService;

    @GetMapping
    public ResponseEntity<List<Route>> getRoute(RouteQuery query) {
        return ResponseEntity.ok(routeService.getRoutes(query));
    }

    @PostMapping
    public ResponseEntity<Route> addRoute(@RequestBody Route route) {
        return ResponseEntity.ok(routeService.save(route));
    }

    @PutMapping
    public ResponseEntity<Route> updateRoute(@RequestBody Route route) {
        return ResponseEntity.ok(routeService.save(route));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRoute(@PathVariable String id) {
        routeService.delete(id);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/refresh")
    public ResponseEntity<String> refresh() {
        routeService.loadRoute();
        return ResponseEntity.ok("refresh ok");
    }
}
