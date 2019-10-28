package com.lv.code.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lv.code.springcloud.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
