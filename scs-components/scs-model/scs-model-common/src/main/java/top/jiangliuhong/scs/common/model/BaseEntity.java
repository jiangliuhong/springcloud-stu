package top.jiangliuhong.scs.common.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * 基础实体
 */
@Getter
@Setter
public class BaseEntity {
    /**
     * id
     */
    @Id
    @Column(name = "c_id")
    private String id;

    /**
     * dt_create_time
     */
    @Column(name = "dt_create_time")
    private Date createTime;

    /**
     * dt_update_time
     */
    @Column(name = "dt_update_time")
    private Date updateTime;
}
