package net.xdclass.demo.bean;

/**
 * 部门映射类
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/10 15:00 </p>
 */
public class Department {

    /**
     * 部门编号
     */
    private Integer id;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 部门地址
     */
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
