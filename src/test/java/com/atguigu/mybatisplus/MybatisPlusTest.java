package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MybatisPlusTest {
    @Autowired
    private UserMapper usermapper;

    @Test
    public void testSelectList(){
        //通过条件构造器查询一个list集合，若没有条件，则可以设置null为参数
//        List<User> list=usermapper.selectList(null);
        List<User> list=usermapper.getAllUser();
        list.forEach(System.out::println);
    }

    @Test
    public void testInsert(){
        //实现新增用户信息
        User user=new User();
        user.setName("张三");
        user.setAge(23);
        user.setEmail("zhangsan@qq.com");
        int result=usermapper.insert(user);
        System.out.println("result:"+result);
        System.out.println("id"+user.getId());
    }

    @Test
    public void testDelete(){

//        int result=usermapper.deleteById(1551942908863672322l);
//        System.out.println("result:"+result);

//        Map<String,Object> map=new HashMap<>();
//        map.put("name","张三");
//        map.put("age",23);
//        int result=usermapper.deleteByMap(map);
//        System.out.println("result:"+result);

        //通过多个id实现批量删除
        List<Long> list=Arrays.asList(1l,2l,3l);
        int result=usermapper.deleteBatchIds(list);
        System.out.println("result:"+result);
    }

    @Test
    public void testUpdate(){
        //修改用户信息
        //UPDATE user SET name=?, email=? WHERE id=?
        User user=new User();
        user.setId(4l);
        user.setName("李四");
        user.setEmail("lisi@qq.com");
        int result =usermapper.updateById(user);
        System.out.println("result:"+result);
    }

    @Test
    public void testSelect(){
        //通过ID查询用户信息
        //SELECT id,name,age,email FROM user WHERE id=?
//        User user=usermapper.selectById(1l);
//        System.out.println(user);

        //根据多个ID查询多个信息用户
        //SELECT id,name,age,email FROM user WHERE id IN ( ? , ? , ? )
//        List<Long> list=Arrays.asList(1l,2l,3l);
//        List<User> list1=usermapper.selectBatchIds(list);
//        list1.forEach(System.out::println);

        //根据map集合中的条件查询用户信息
        //SELECT id,name,age,email FROM user WHERE name = ? AND age = ?
//        Map<String,Object> map=new HashMap<>();
//        map.put("name","Jack");
//        map.put("age",20);
//        List<User> users=usermapper.selectByMap(map);
//        users.forEach(System.out::println);

        Map<String,Object> map=usermapper.selectMapById(1l);
        System.out.println(map);


    }

}
