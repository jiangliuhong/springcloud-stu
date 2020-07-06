package top.jiangliuhong.scs.gateway.module;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_route", schema = "db_base")
// @GenericGenerator(name = "jpa-uuid", strategy = "uuid")
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPredicates() {
        return predicates;
    }

    public void setPredicates(String predicates) {
        this.predicates = predicates;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }
}
