package com.lv.code.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.lv.code.mapper.UserMapper;
import com.lv.code.model.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "添加用户", notes = "根据参数添加用户")
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public int add(@RequestBody User user) {
        return userMapper.insert(user);
    }

    @ApiOperation(value = "查询用户", notes = "根据参数查询用户")
    @RequestMapping(value = "/user/get/{id}", method = RequestMethod.GET)
    public User get(@PathVariable("id") Long id) {
        return userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getId, id));
    }

    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public List<User> list() {
        return userMapper.selectList(null);
    }
}