package com.mybatis.day02.many2one;

public interface EmployeeMapper {
    Employee get(long id);

    void save(Employee employee);

}
