package top.jiangliuhong.scs.gateway.module;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "t_route", schema = "db_base")
public class Route implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    // @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "c_id")
    private String id;

    @Column(name = "c_name")
    private String name;

    @Column(name = "c_predicates")
    private String predicates;

    @Column(name = "c_url")
    private String url;

    @Column(name = "c_filters")
    private String filters;

}
