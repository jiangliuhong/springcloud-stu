package top.jiangliuhong.scs.gateway.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import top.jiangliuhong.scs.gateway.module.Route;
import top.jiangliuhong.scs.gateway.repository.RouteRepository;

@Service
public class RouteService {

    @Resource
    private RouteRepository routeRepository;

    public List<Route> getAll(){
        Iterable<Route> all = routeRepository.findAll();
        return Lists.newArrayList(all);
    }
}
