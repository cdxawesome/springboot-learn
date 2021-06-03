package com.cdx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cdx.entity.User;


/**
 * 数据服务层
 */
public interface UserService extends IService<User> {
    /**
     * 添加user
     */
    void addUser(User user);
}
