package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.CompanyMapper;
import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class MybatisPlusTest {
    @Autowired
    private UserMapper usermapper;

    @Resource
    private CompanyMapper companyMapper;

    @Test
    public void testSelectList(){
        //通过条件构造器查询一个list集合，若没有条件，则可以设置null为参数
//        List<User> list=usermapper.selectList(null);
        List<User> list=usermapper.getAllUser();
        list.forEach(System.out::println);
    }


    /**
     * 实体类与数据库表名、字段不一致：
     * 1、@TableName("com")：将实体类名与mysql表名进行映射，执行语句时，表名使用com
     * 2、@TableId(value = "`Rank`")：在实体类中主键的属性上通过@TableId将其标识为主键,字段名不一致可以通过value进行设置
     * 3、@TableField(value = "`Rank`")：与@TableId同理，只是标识普通字段
     * 注意：由于数据库表字段名称设计不合理，导致与MySQL数据库关键字或者预留关键字一致，在这种情况下，将会导致数据插入、查询、修改等操作不成功，
     *  a> mybatis-plus通过@TableId(value = "`Rank`")的value加上反单引号 `
     *  b> mybatis通过@Column(name = "`key`")
     *  c>在mapper.xml文件在sql语句手动加上反单引号
     */
    @Test
    public void testBaseMapperCompany(){
//        companyMapper.getpartCompany(0,10).forEach(System.out::println);
        companyMapper.selectList(null).forEach(System.out::println);

    }

}
