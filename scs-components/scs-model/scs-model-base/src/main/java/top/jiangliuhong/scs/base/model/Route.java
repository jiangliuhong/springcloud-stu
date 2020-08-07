package top.jiangliuhong.scs.base.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import top.jiangliuhong.scs.common.model.BaseEntity;

/**
* 
* 数据表db_base.t_route映射bean，由Mybaits自动生成工具生成
* @author null
* @date 2020-08-08
*/
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
    @ApiModelProperty("名称")
    private String name;

    /**
     * 断言
     */
    @Column(name = "c_predicates")
    @ApiModelProperty("断言")
    private String predicates;

    /**
     * url
     */
    @Column(name = "c_url")
    @ApiModelProperty("url")
    private String url;

    /**
     * 过滤器
     */
    @Column(name = "c_filters")
    @ApiModelProperty("过滤器")
    private String filters;
}