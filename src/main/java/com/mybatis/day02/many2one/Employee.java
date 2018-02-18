package com.mybatis.day02.many2one;

public class Employee {

    private Integer id;
    private String name;
    private Department dept;


    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    @Override
    /**
     * 由于懒加载的问题,不打印 关联的 dept 的内容
     * */
    public String toString() {
        return "id=" + id + ", name=" + name + "， dept=" + dept;
    }
}
