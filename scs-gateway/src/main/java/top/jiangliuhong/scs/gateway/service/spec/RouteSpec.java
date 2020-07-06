package top.jiangliuhong.scs.gateway.service.spec;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.google.common.collect.Lists;

import top.jiangliuhong.scs.gateway.bean.req.RouteQuery;
import top.jiangliuhong.scs.gateway.module.Route;

/**
 * 路由特殊查询
 */
public class RouteSpec implements Specification<Route> {

    private RouteQuery query;

    public RouteSpec(RouteQuery query) {
        this.query = query;
    }

    @Override
    public Predicate toPredicate(Root<Route> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder builder) {
        // 所有的断言 及条件
        List<Predicate> predicates = Lists.newArrayList();
        if (StringUtils.isNotBlank(this.query.getIdname())) {
            Predicate likeId = builder.like(root.get("id"), "%" + this.query.getIdname() + "%");
            Predicate likeName = builder.like(root.get("name"), "%" + this.query.getIdname() + "%");
            predicates.add(builder.or(likeId, likeName));
        }
        return builder.and(predicates.toArray(new Predicate[0]));
    }
}
