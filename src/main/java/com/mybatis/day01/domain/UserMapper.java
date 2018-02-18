package com.mybatis.day01.domain;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    @Insert({"INSERT INTO user(username,password,age)",
            " VALUES (#{username},#{password},#{age})"})
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void save(User user);

    //@Update("UPDATE user SET username=#{username} , password=#{password} , age=#{age} WHERE id=#{id}")
    void update(User user);

    User get(Long id);

    List<User> listAll();

    void delete(Long id);

    List<User> listAllWithConditon(User u);

    /**
     *
     * @param username Param 里面的 String username 指的是数据库里的 column name
     * @param password 同上
     * @return 封装好的 user 对象
     * 底层上，param 其实还是自动封装好 Map 对象，再调用 selectOne()
     */
    User login(@Param("username") String username , @Param("password") String password);

}
