package top.jiangliuhong.scs.base.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import top.jiangliuhong.scs.common.model.BaseEntity;

@Getter
@Setter
@ToString
@ApiModel("路由信息")
@Table(name = "db_base.t_route")
public class Route extends BaseEntity {
    /**
     * 名称
     */
    @Column(name = "c_name")
    private String name;

    /**
     * 断言
     */
    @Column(name = "c_predicates")
    private String predicates;

    /**
     * url
     */
    @Column(name = "c_url")
    private String url;

    /**
     * 过滤器
     */
    @Column(name = "c_filters")
    private String filters;
}