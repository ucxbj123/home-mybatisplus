package com.atguigu.mybatisplus.mapper;

import com.atguigu.mybatisplus.pojo.Company;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CompanyMapper  extends BaseMapper<Company> {
    //@Param("start"),@Param("end")
    List<Company> getpartCompany( int start, int end);
}
