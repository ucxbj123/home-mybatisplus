package com.atguigu.mybatisplus.mapper;

import com.atguigu.mybatisplus.pojo.User;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Mapper
public interface UserMapper  extends BaseMapper<User> {
    List<User> getAllUser();
}
