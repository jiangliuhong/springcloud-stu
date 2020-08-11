package top.jiangliuhong.scs.base.api;

import static top.jiangliuhong.scs.base.constants.ApiConstatns.API_ROUTE_V1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import top.jiangliuhong.scs.base.model.Route;
import top.jiangliuhong.scs.base.service.RouteService;

@RestController
public class RouteApi implements IRouteApi {

    @Autowired
    private RouteService routeService;

    @GetMapping(value = API_ROUTE_V1 + "/{id}")
    @Override
    public ResponseEntity<Route> getById(@PathVariable("id") String id) {
        return ResponseEntity.ok(routeService.getRouteById(id));
    }
}
