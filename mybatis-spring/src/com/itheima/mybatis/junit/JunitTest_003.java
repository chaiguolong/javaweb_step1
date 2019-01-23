package com.itheima.mybatis.junit;

import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.mybatis.dao.UserDao_003;
import com.itheima.mybatis.mapper.UserMapper_003;
import com.itheima.mybatis.pojo.User;

public class JunitTest_003 {

	@Test
	public void testSelectUserById() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext_003.xml");
		UserDao_003 userDao_003 = (UserDao_003)ac.getBean("userDao_003");
		User user = userDao_003.findUserById(10);
		System.out.println(user);
	}

	@Test
	public void testMapper() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext_003.xml");
		UserMapper_003 userMapper_003 = ac.getBean(UserMapper_003.class);
		User user = userMapper_003.findUserById(10);
		System.out.println(user);
	}
}



