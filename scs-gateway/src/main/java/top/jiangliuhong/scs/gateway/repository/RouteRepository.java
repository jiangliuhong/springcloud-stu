package top.jiangliuhong.scs.gateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import top.jiangliuhong.scs.gateway.module.Route;

public interface RouteRepository extends JpaRepository<Route, String>, JpaSpecificationExecutor<Route> {

}
