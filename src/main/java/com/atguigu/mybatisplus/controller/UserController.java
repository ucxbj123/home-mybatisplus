package com.atguigu.mybatisplus.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.Company;
import com.atguigu.mybatisplus.pojo.User;
import io.swagger.annotations.*;
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
@Api(tags = "User接口文档",value ="UserController" )
public class UserController {
    /**
     * @Api()用在请求的类上，表示对类的说明，也表示了这个类是swagger2的资源
     * 参数：
     *  tags:说明该类的作用，参数是个数组，可以设置多个
     *  value:该参数没什么意义，在UI界面上不显示，不需要配置
     *  description:用户基本操作信息
     *  @ApiOperation:标识Swagger识别的方法
     *  @ApiImplicitParam:标识方法的参数说明
     *  @ApiResponse:标识方法返回值的说明
     *  @ApiModelProperty:标识JavaBean的属性
     *  @ApiModel:标识Swagger识别的JavaBean，放在JavaBean的类定义上
     */

    @Resource
    private UserMapper userMapper;

    /**
     * 要在models显示实体类要有前提:
     * a> 需要在实体类标注@ApiModel与@ApiModelProperty
     * b> 通过注解将@ApiResponse的response=User.class将实体类包括或者通过@ApiOperation的response=User.class同样也可以
     *
     */
    @ApiOperation(value = "接收json数据",notes = "传id进行查询",response = User.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200,message = "用户信息",response=User.class)
//    })
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
