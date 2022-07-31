package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@SpringBootTest
class MybatisplusApplicationTests {

	/**
	 * springboot集成mybatis操作数据的方式：
	 * 1、使用@MapperScan("com.atguigu.mybatisplus.mapper")或者@Mapper注解接口，启动会自动生成接口代理类，名字为首字母小写的接口名字
	 * 可以通过@Autowired或者@Resource将接口实现类进行注入直接使用
	 * 2、Springboot启动会自动装配生成实例sqlSessionTemplate,implements SqlSession，可以直接通过getMapper动态生成接口类进行sql调用
	 * 3、Springboot启动会自动装配生成实例sqlSessionFactory，通过sqlSessionFactory获取Sqlsession对象进行操作
	 */
	@Autowired
	SqlSessionFactory sqlSessionFactory;

//
//	@Autowired
//	UserMapper userMapper;

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	SqlSessionTemplate sqlSessionTemplate2;

	@Test
	void contextLoads() {
		ApplicationContext run =  SpringApplication.run(MybatisplusApplication.class);

		String[] beans = run.getBeanDefinitionNames();

		for(String bean:beans){

			if(bean.contains("sqlSession")){
				System.out.println(bean);
			}

		}
//		SqlSession sqlSession=sqlSessionFactory.openSession(true);
//		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		UserMapper userMapper=sqlSessionTemplate.getMapper(UserMapper.class);
		userMapper.getAllUser().forEach(System.out::println);
	}

	@Test
	public void testSqlSessionTemplate(){
		System.out.println(sqlSessionTemplate);
		System.out.println(sqlSessionTemplate2);
	}

}
