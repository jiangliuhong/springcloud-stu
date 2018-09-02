package pers.jarome.scs.core.model;

/**
 * student实体类
 *
 * @author
 */
public class Student {
    /***/
    private String id;
    /***/
    private String name;
    /***/
    private String num;

    /**
     * 实例化
     */
    public Student() {
        super();
    }

    /**
     * 获取id
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取name
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取num
     *
     * @return
     */
    public String getNum() {
        return num;
    }

    /**
     * 设置num
     *
     * @param num
     */
    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + " , name=" + name + " , num=" + num + "  ]";

    }

}
