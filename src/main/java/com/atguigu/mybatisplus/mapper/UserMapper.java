package com.atguigu.mybatisplus.mapper;

import com.atguigu.mybatisplus.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Mapper
public interface UserMapper  {
    List<User> getAllUser();
}
