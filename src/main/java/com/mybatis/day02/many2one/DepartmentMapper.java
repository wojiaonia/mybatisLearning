package com.mybatis.day02.many2one;

public interface DepartmentMapper {
    Department get(Long id);
    void save(Department dept);

}
