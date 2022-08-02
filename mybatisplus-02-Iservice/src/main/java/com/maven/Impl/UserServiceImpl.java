package com.maven.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.maven.Mapper.UserMapper;
import com.maven.POJO.User;
import com.maven.Service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
