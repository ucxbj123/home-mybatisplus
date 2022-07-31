package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.CompanyMapper;

import com.atguigu.mybatisplus.pojo.Company;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;


@SpringBootTest
public class MybatisTest {

    @Resource(name = "companyMapper")
    private CompanyMapper companyMapper;

    @Test
    public void mybatisArgsTest(){
        System.out.println(companyMapper);
        List<Company> list=companyMapper.getpartCompany(10,20);
        list.forEach(System.out::println);
    }
}
