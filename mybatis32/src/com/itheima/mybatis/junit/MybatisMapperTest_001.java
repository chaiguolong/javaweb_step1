package com.itheima.mybatis.junit;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.junit.Test;

import com.itheima.mybatis.mapper.UserMapper_001;
import com.itheima.mybatis.pojo.User;

public class MybatisMapperTest_001 {
	@Test
	public void testMapper() throws Exception{
		//加载核心配置文件
		String resource = "sqlMapConfig_001.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		UserMapper_001 userMapper_001 = sqlSession.getMapper(UserMapper_001.class);
		User user = userMapper_001.findUserById(25);
		System.out.println(user);

		
	}
}



