package com.lv.code.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.lv.code.mapper.UserMapper;
import com.lv.code.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public int add(@RequestBody User user) {
        return userMapper.insert(user);
    }

    @RequestMapping(value = "/user/get/{id}", method = RequestMethod.GET)
    public User get(@PathVariable("id") Long id) {
        return userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getId, id));
    }

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public List<User> list() {
        return userMapper.selectList(null);
    }
}