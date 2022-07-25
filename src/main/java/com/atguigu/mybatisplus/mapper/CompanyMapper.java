package com.atguigu.mybatisplus.mapper;

import com.atguigu.mybatisplus.pojo.Company;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CompanyMapper extends BaseMapper<Company> {

    List<Company> getpartCompany(@Param("start") int start,@Param("end") int end);
}
