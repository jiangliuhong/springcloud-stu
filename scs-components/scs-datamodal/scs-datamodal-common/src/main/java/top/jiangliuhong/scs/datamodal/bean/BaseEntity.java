package top.jiangliuhong.scs.datamodal.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import java.util.Date;

/**
 * 基础实体
 */
@Getter
@Setter
public class BaseEntity {
    @Id
    private String bh;
    private Date createTime;
    private Date updateTime;
}
