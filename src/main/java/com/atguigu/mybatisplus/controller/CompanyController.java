package com.atguigu.mybatisplus.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.mybatisplus.mapper.CompanyMapper;
import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.Company;
import com.atguigu.mybatisplus.pojo.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Resource(name = "userMapper")
    private UserMapper userMapper;

    @Resource(name = "companyMapper")
    private CompanyMapper companyMapper;

    /**
     * 前端上传查询ID，集成mybatis-plus进行批量查询，接口BaseMapper使用封装好的根据ID批量查询功能并返回JSON格式的数据
     * @param
     * @return
     */
    @RequestMapping(value = "byrank",method = RequestMethod.POST)
    public Object getUserByBatchId(@RequestBody String ranks){
//        User user=userMapper.selectById(id);
//        JSONObject jsonObject= JSON.parseObject(JSON.toJSONString(user));
//        return jsonObject;
        System.out.println("mapper"+companyMapper);
        List<Map> list=JSONObject.parseArray(ranks,Map.class);
        List<Long> id= new ArrayList<>();
        for(Map<String,Long> map:list){
            id.add(map.get("id"));
        }
        System.out.println(id);
//        List<User> list1=userMapper.selectBatchIds(id);
        try {
            List<Company> list1=companyMapper.selectBatchIds(id);
            JSONArray jsonArray=JSONArray.parseArray(JSON.toJSONString(list1));
            return jsonArray;
        }catch (Exception e){
            System.out.println("错误：");
            e.printStackTrace();
            return "{'status':error}";
        }

    }
}
