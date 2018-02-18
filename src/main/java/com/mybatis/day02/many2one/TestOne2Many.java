package com.mybatis.day02.many2one;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestOne2Many {

    @Test
    public void testGet() throws IOException{
        SqlSession session = new MyBatisUtil().openSession();
        //proxy
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Employee employee = employeeMapper.get(1L);
        System.out.println(employee);

        session.close();
    }

    @Test
    public void testSave() throws IOException{
        SqlSession session = new MyBatisUtil().openSession();
        //proxy
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);

        Employee e1 = new Employee();
        e1.setName("huge");

        Department d1 = new Department();

        //先保存 dept 避免 保存 employee 时 null
        d1.setName("ef");

        //建立关系
        e1.setDept(d1);

        //通过这个打印可以了解到 xml 里面的 useGenerateKey = true 是，通过Mybatis的 proxy 动态代理对象 完成 id 自动生成并且获取主键 并将值返回到 keyroperty 对应的 resultMap 的字段中
        //最后 字段 存于 resultType 的对象实例里 通过代理对象的 get() 方法 传递。
        System.out.println(d1.getId());

        departmentMapper.save(d1);
        employeeMapper.save(e1);

        //remember to 提交!!!!
        session.commit();
        session.close();

    }

}
