package top.jiangliuhong.scs.base.api;

import static top.jiangliuhong.scs.base.constants.ApiConstatns.API_ROUTE_V1;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import top.jiangliuhong.scs.base.model.Route;
import top.jiangliuhong.scs.common.config.FeignConfig;

/**
 * 
 * RouteApi
 * 
 * @description 路由API
 * @author jiangliuhong
 * @date 2020/8/8 15:42
 * @version 1.0.0
 */
@FeignClient(value = "${scs.server.base:scs-base}", configuration = FeignConfig.class)
public interface IRouteApi {

    /**
     * 根据id查询路由
     * @param id id
     * @return 路由信息
     */
    @GetMapping(value = API_ROUTE_V1 + "/{id}")
    ResponseEntity<Route> getById(@PathVariable("id") String id);

}
