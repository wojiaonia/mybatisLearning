package com.mybatis.day02.many2one;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class MyBatisUtil {
    public SqlSession openSession() throws IOException{
        //create factory
        SqlSessionFactory factory =new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        //get  sqlsession
        SqlSession session = factory.openSession();
        return session;
    }
}
