package com.mybatis.day01.domain;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class MapperTest {
    //利用 Spring 的 proxy
    // 实现动态创建 Mapper 的实现对象， 这样就不是 xml 配置啦
    // 可以实现 验证等等了
    @Test
    public void testListAll() throws IOException {
        SqlSession session = new MyBatisUtil().openSession();



        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.listAll();

        for (User user:users){
            System.out.println(user);
        }

        session.close();
    }

    @Test
    public void testListAllWithCondition() throws IOException {
        SqlSession session = new MyBatisUtil().openSession();

        User u = new User();
        u.setAge(28);
        u.setUsername("mao");

        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.listAllWithConditon(u);

        for (User user:users){
            System.out.println(user);
        }

        session.close();
    }
}
