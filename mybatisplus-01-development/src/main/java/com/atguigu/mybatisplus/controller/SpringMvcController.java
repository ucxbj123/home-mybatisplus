package com.atguigu.mybatisplus.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringMvcController {

    /**
     * params里面的参数：
     * "param"：要求请求映射所匹配的请求必须携带param请求参数
     * "!param"：要求请求映射所匹配的请求必须不能携带param请求参数
     * "param=value"：要求请求映射所匹配的请求必须携带param请求参数且param=value
     * "param!=value"：要求请求映射所匹配的请求必须携带param请求参数但是param!=value
     * 注意："msg!=1"，不能写成 "msg != 1"，会失效
     * @param msg
     * @return
     */
    @RequestMapping(value = {"/springmvc","mvc"},method = RequestMethod.POST,params = {"msg!=1"})
    public Object Messages(String msg){
        return msg;
    }

    /**
     * 当请求路径中将某些数据通过路径的方式传输到服
     * 务器中，就可以在相应的@RequestMapping注解的value属性中通过占位符{xxx}表示传输的数据，在
     * 通过@PathVariable注解，将占位符所表示的数据赋值给控制器方法的形参
     */
    @RequestMapping(value = "/mvc/{id}/{name}")
    public Object getMessageByPathVariable(@PathVariable(value = "id")Integer id,@PathVariable(value = "name") String name){
        return "id:"+id+" "+"name:"+name;
    }
}
