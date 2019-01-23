package com.itheima.mybatis.junit;

import org.apache.ibatis.session.SqlSessionFactory;

import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.mybatis.dao.UserDaoImpl_001;
import com.itheima.mybatis.dao.UserDao_001;
import com.itheima.mybatis.mapper.UserMapper_001;
import com.itheima.mybatis.pojo.User;

public class JunitTest_001 {
	@Test
	public void testSelectUserById() {
		//创建spring上下文
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext_001.xml");
		//创建userDao_001
		UserDao_001 userDao_001 = (UserDao_001)ac.getBean("userDao_001");
		User user = userDao_001.findUserById(10);
		System.out.println(user);

	}


	@Test
	public void testMapper() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext_001.xml");
		UserMapper_001 userMapper_001 = ac.getBean(UserMapper_001.class);
		// UserMapper_001 userMapper_001 =(UserMapper_001) ac.getBean("userMapper_001");
		User user = userMapper_001.findUserById(10);
		System.out.println(user);
	}

}



