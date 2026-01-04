package com.it.librarysystem.controller;

import com.it.librarysystem.entity.User;
import com.it.librarysystem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    // 只负责登录，不应该有 borrowBook 的代码
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {
        User dbUser = userMapper.getByUsernameAndPassword(user.getUsername(), user.getPassword());

        Map<String, Object> result = new HashMap<>();
        if (dbUser != null) {
            result.put("code", 200);
            result.put("msg", "登录成功");
            result.put("data", dbUser);
        } else {
            result.put("code", 400);
            result.put("msg", "用户名或密码错误");
        }
        return result;
    }
}