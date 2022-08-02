package com.maven.Mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.maven.POJO.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> getAllUser();
}
