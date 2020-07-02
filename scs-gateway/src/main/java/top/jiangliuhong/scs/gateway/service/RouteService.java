package top.jiangliuhong.scs.gateway.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.google.common.collect.Lists;

import top.jiangliuhong.scs.gateway.module.Route;
import top.jiangliuhong.scs.gateway.repository.RouteRepository;

@Service
public class RouteService {

    private static final Logger logger = LoggerFactory.getLogger(RouteService.class);

    @Resource
    private RouteRepository routeRepository;

    @Autowired
    private RouteDefinitionWriter routeDefinitionWriter;

    private ApplicationEventPublisher publisher;

    /**
     * 查询所有配置
     * 
     * @return 路由配置
     */
    public List<Route> getRoutes() {
        Iterable<Route> all = routeRepository.findAll();
        return Lists.newArrayList(all);
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
            }
//            if(StringUtils)
            // definition.setFilters();
            // routeDefinitionWriter.save();
        }
        // 刷新路由
        ApplicationEventUtils.pushEvent(new RefreshRoutesEvent(this));
    }

}
