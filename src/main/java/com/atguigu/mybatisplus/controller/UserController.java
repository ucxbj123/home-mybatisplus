package com.atguigu.mybatisplus.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Api(tags = "User接口文档")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @ApiOperation(value = "接收json数据",notes = "传id进行查询")
    @RequestMapping(value = "ById",method = RequestMethod.POST)
    public Object getUserBatchyIds(@ApiParam(name = "接收数据",defaultValue = "{}") @RequestBody String ids){
        List<Map> maps= JSON.parseArray(ids,Map.class);
        List<Long> longList=new ArrayList<>();
        for (Map<String,Long> map:maps){
            longList.add(map.get("id"));
        }
        List<User> list=userMapper.selectBatchIds(longList);
        JSONArray jsonArray=JSON.parseArray(JSON.toJSONString(list));
        return jsonArray;
    }

}
