package com.itheima.mybatis.junit;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.junit.Before;
import org.junit.Test;

import com.itheima.mybatis.dao.UserDaoImpl_002;
import com.itheima.mybatis.dao.UserDao_002;
import com.itheima.mybatis.pojo.User;

public class MybatisDaoTest_002 {
	public SqlSessionFactory sqlSessionFactory;
	@Before
	public void before() throws Exception{
		//加载核心配置文件
		String resource = "sqlMapConfig_002.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建sqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
	}

	@Test
	public void testDao() throws Exception{
		before();
		UserDao_002 userDao_002 = new UserDaoImpl_002(sqlSessionFactory);
		User user = userDao_002.selectUserById(22);
		System.out.println(user);
	}
}



