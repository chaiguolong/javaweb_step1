package com.itheima.mybatis.junit;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.junit.Before;
import org.junit.Test;

import com.itheima.mybatis.dao.UserDaoImpl_003;
import com.itheima.mybatis.dao.UserDao_003;
import com.itheima.mybatis.pojo.User;

public class MybatisDaoTest_003 {
	public SqlSessionFactory sqlSessionFactory;
	@Before
	public void before() throws Exception{
		//加载核心配置文件
		String resource = "sqlMapConfig_003.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建sqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
	}

	@Test
	public void testDao() throws Exception{
		before();
		UserDao_003 userDao_003 = new UserDaoImpl_003(sqlSessionFactory);
		User user = userDao_003.selectUserById(24);
		System.out.println(user);

	}
}



