package com.maven.mybatisplus;

import com.maven.mybatisplus.impl.UserServiceImpl;
import com.maven.mybatisplus.pojo.User;
import com.maven.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MybatisplusServiceTest {
    /**
     * 如果接口有多个接口实现类，通过注解方式注入的时候需要指明具体实现类的bean示例名
     */
    @Resource(name = "userServiceImpl")
    private UserService userService;

    @Test
    public void testGetCount(){
        System.out.println("总记录数："+userService.count());
    }

    @Test
    public  void testInsertMore(){
        //批量添加
        //INSERT INTO user ( id, name, age ) VALUES ( ?, ?, ? )
        List<User> list=new ArrayList<>();
        for(int i=1;i<=10;i++){
            User user=new User();
            user.setAge(20+i);
            user.setName("ybc"+i);
            list.add(user);
        }
        Boolean b=userService.saveBatch(list);
        System.out.println(b);
    }


}
