package com.itheima.mybatis.junit;

import org.apache.ibatis.session.SqlSessionFactory;

import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.mybatis.dao.UserDao_002;
import com.itheima.mybatis.mapper.UserMapper_002;
import com.itheima.mybatis.pojo.User;

public class JunitTest_002 {

	@Test
	public void testSelectUserById() {
		//创建spring上下文
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext_002.xml");
		//创建userDao_002
		UserDao_002 userDao_002 = (UserDao_002)ac.getBean("userDao_002");
		User user = userDao_002.findUserById(10);
		System.out.println(user);
		
	}

	@Test
	public void testMapper() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext_002.xml");
		UserMapper_002 userMapper_002 = ac.getBean(UserMapper_002.class);
		User user = userMapper_002.findUserById(10);
		System.out.println(user);
	}
}



