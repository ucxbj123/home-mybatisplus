package com.atguigu.mybatisplus.impl;

import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.User;
import com.atguigu.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
