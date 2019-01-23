package com.itheima.mybatis.junit;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.junit.Test;

import com.itheima.mybatis.mapper.UserMapper_002;
import com.itheima.mybatis.pojo.User;

public class MybatisMapperTest_002 {
	@Test
	public void testMapper() throws Exception{
		//加载核心配置文件
		String resource = "sqlMapConfig_002.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//执行sql
		UserMapper_002 userMapper_002 = sqlSession.getMapper(UserMapper_002.class);
		User user = userMapper_002.findUserById(10);
		System.out.println(user);

	}
}



