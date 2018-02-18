package com.mybatis.day01.domain;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CRUDTest {

    @Test
    public void testSave() throws IOException {

        SqlSession session = new MyBatisUtil().openSession();
        User userA = new User();
        userA.setUsername("ming1");
        userA.setAge(23);
        userA.setPassword("123456");
        Long l = new Long(1);
        userA.setId(l);

        //执行 session 里面 的 save 操作 通过 namespace + id
        //session.insert("com.mybatis.day01.domain.UserMapper.save",userA);

        //更新，使用 usermapper api 来实现 insert
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.save(userA);

        //提交
        session.commit();
        session.close();
    }

    @Test
    public void testGet() throws IOException {
        SqlSession session = new MyBatisUtil().openSession();

        User userB = new User();

        //返回 对应类型 也就是 mapper 里面的 resultType
        //若不设置映射规则，则 mybatis 会根据同名匹配规则，例如 user 表里有 username 属性，则调用 setUsername() 方法
        //mapper class is recommanded ,in case of the difference naming stratigies of DB and app
        //userB = session.selectOne("com.mybatis.day01.domain.UserMapper.get",1L);

        //更新，使用 usermapper api 来实现 get
        UserMapper mapper = session.getMapper(UserMapper.class);
        //获取第一条字段
        mapper.get(1L);
        System.out.println(userB);
        //提交

        session.close();
    }
    @Test
    public void testUpdate() throws IOException{
        SqlSession session = new MyBatisUtil().openSession();

        User u = new User();

        u.setId(1L);
        u.setPassword("4");
        u.setUsername("lisi");
        u.setAge(28);

        //更新，使用 usermapper api 来实现 update
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.update(u);
        //手动提交事务
        session.commit();
        session.close();
    }

    @Test
    public void testListAll() throws IOException{
        SqlSession session = new MyBatisUtil().openSession();

        //更新，使用 usermapper api 来实现 get
        UserMapper mapper = session.getMapper(UserMapper.class);

        List<User> users = session.selectList("com.mybatis.day01.domain.UserMapper.listAll");

        for (User user:users){
            System.out.println(user);
        }

        session.close();
    }

    @Test
    public void testDelete() throws IOException{
        SqlSession session = new MyBatisUtil().openSession();

        //更新，使用 usermapper api 来实现 get
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.delete(1L);

        session.commit();
        session.close();
    }

    @Test
    public void testLogin() throws IOException{
        SqlSession session = new MyBatisUtil().openSession();
        User u = new User();
//        Map<String,Object> map = new HashMap<String,Object>(1);
//        map.put("username","ming1");
//        map.put("password","123456");
        //更新，使用 usermapper api 来实现 get
        UserMapper mapper = session.getMapper(UserMapper.class);
        u = mapper.login("ming1","123456");
        System.out.println(u);
        session.close();
    }
}
