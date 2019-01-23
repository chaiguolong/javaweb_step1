package com.itheima.mybatis.junit;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.junit.Before;
import org.junit.Test;

import com.itheima.mybatis.dao.UserDaoImpl_001;
import com.itheima.mybatis.dao.UserDao_001;
import com.itheima.mybatis.pojo.User;

public class MybatisDaoTest_001 {

	public SqlSessionFactory sqlSessionFactory;
	@Before
	public void before() throws Exception {
		//加载核心配置文件
		String resource = "sqlMapConfig_001.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
	}
	@Test
	public void testDao() throws Exception{
		before();
		UserDao_001 userDao_001 = new UserDaoImpl_001(sqlSessionFactory);
		User user = userDao_001.selectUserById(16);
		System.out.println(user.toString());
	}
}



