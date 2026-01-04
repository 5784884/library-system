package com.it.librarysystem.mapper;

import com.it.librarysystem.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    // 根据用户名和密码查询用户 (用于登录)
    @Select("SELECT * FROM sys_user WHERE username = #{username} AND password = #{password}")
    User getByUsernameAndPassword(String username, String password);
}