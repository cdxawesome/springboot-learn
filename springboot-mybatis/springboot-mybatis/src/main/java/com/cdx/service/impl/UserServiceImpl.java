package com.cdx.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdx.entity.User;
import com.cdx.mapper.UserMapper;
import com.cdx.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 数据服务层实现
 */
@Service
@DS("slave")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

//    @DS("master")
    @Override
    public void addUser(User user) {
        baseMapper.insert(user);
    }
}
