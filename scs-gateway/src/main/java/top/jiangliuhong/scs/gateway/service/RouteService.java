package top.jiangliuhong.scs.gateway.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import reactor.core.publisher.Mono;
import top.jiangliuhong.scs.gateway.bean.req.RouteQuery;
import top.jiangliuhong.scs.gateway.module.Route;
import top.jiangliuhong.scs.gateway.repository.RouteRepository;
import top.jiangliuhong.scs.gateway.service.spec.RouteSpec;

@Service
public class RouteService {

    private static final Logger logger = LoggerFactory.getLogger(RouteService.class);

    @Resource
    private RouteRepository routeRepository;

    @Autowired
    private RouteDefinitionWriter routeDefinitionWriter;

    public List<Route> getRoutes() {
        return getRoutes(null);
    }

    /**
     * 查询所有配置
     * 
     * @return 路由配置
     */
    public List<Route> getRoutes(RouteQuery query) {
        List<Route> res;
        if (query == null) {
            res = Lists.newArrayList(routeRepository.findAll());
        } else {
            // ExampleMatcher matcher = ExampleMatcher.matching()
            // .withMatcher("id", ExampleMatcher.GenericPropertyMatchers.contains())
            // .withMatcher("firstname", match -> match.startsWith());
            // Example<Route> example = Example.of(new Route(),matcher);
            res = routeRepository.findAll(new RouteSpec(query));
        }
        return res;
    }

    /**
     * 保存路由信息
     * 
     * @param route 路由
     * @return 路由
     */
    public Route save(Route route) {
        return routeRepository.save(route);
    }

    /**
     * 删除路由
     * 
     * @param id id
     */
    public void delete(String id) {
        routeRepository.deleteById(id);
    }

    /**
     * 加载配置
     */
    public void loadRoute() {
        List<Route> routes = getRoutes();
        if (CollectionUtils.isEmpty(routes)) {
            logger.warn("当前没有路由需要加载");
            return;
        }
        for (Route route : routes) {
            RouteDefinition definition = new RouteDefinition();
            definition.setId(route.getId());
            try {
                definition.setUri(new URI(route.getUrl()));
            } catch (URISyntaxException e) {
                logger.error("初始化uri失败:" + route.getUrl(), e);
                continue;
            }
            if (StringUtils.isBlank(route.getPredicates())) {
                logger.warn("{}[{}]的Predicates为空", route.getId(), route.getName());
                continue;
            }
            // 路由设置
            List<PredicateDefinition> predicates = Lists.newArrayList();
            List<String> predicatesList = JSON.parseArray(route.getPredicates(), String.class);
            for (String p : predicatesList) {
                predicates.add(new PredicateDefinition(p));
            }
            definition.setPredicates(predicates);
            // 过滤器设置
            if (StringUtils.isNotBlank(route.getFilters())) {
                List<FilterDefinition> filters = Lists.newArrayList();
                List<String> filtersList = JSON.parseArray(route.getFilters(), String.class);
                for (String f : filtersList) {
                    filters.add(new FilterDefinition(f));
                }
                definition.setFilters(filters);
            }
            routeDefinitionWriter.save(Mono.just(definition)).subscribe();
        }
        // 刷新路由
        ApplicationEventUtils.pushEvent(new RefreshRoutesEvent(this));
    }
}
