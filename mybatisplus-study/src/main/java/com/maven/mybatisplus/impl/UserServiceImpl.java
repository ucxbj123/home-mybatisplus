package com.maven.mybatisplus.impl;

import com.maven.mybatisplus.mapper.UserMapper;
import com.maven.mybatisplus.pojo.User;
import com.maven.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
