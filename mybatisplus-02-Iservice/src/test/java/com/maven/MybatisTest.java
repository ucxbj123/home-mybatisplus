package com.maven;

import com.maven.POJO.User;
import com.maven.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class MybatisTest {

    @Autowired
    @Qualifier(value = "userServiceImpl")
//    @Qualifier(value = "userService")
    private UserService userService;

    @Test
    public void IServiceCountTest(){
        System.out.println(userService.count());
    }

    @Test
    public void IServiceTest(){
//        User user=new User();
//        user.setId(6l);
//        user.setAge(30);
//        user.setName("梁爽");
//        List<User> list= Arrays.asList(user);
//        boolean result=userService.saveBatch(list);
//        System.out.println(result);
    }

    @Test
    public void IServiceDeleteTest(){
        System.out.println(userService.removeById(1552108508550897665l));
    }
}
