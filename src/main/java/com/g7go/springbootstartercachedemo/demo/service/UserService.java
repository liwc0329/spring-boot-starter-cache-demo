package com.g7go.springbootstartercachedemo.demo.service;

import com.g7go.springbootstartercachedemo.demo.pojo.User;

/**
 * @author lwc
 */
public interface UserService {

    /**
     * 插入用户
     */
    User saveUser(User user);

    /**
     * 获取用户
     */
    User findUser();

    /**
     * 更新用户信息
     */
    User updateUser();

    /**
     * 清除缓存的用户信息
     */
    void clearUser();
}