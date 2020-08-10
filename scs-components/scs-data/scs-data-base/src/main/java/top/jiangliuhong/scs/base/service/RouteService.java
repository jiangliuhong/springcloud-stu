package top.jiangliuhong.scs.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.jiangliuhong.scs.base.mapper.RouteMapper;
import top.jiangliuhong.scs.base.model.Route;

@Service
public class RouteService {

    @Autowired
    private RouteMapper routeMapper;

    /**
     * 根据id查询
     * 
     * @param id id
     * @return Route
     */
    public Route getRouteById(String id) {
        return routeMapper.selectByPrimaryKey(id);
    }

}
