package com.itheima.mybatis.junit;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.apache.logging.log4j.core.config.Order;

import org.junit.Test;

import com.itheima.mybatis.mapper.OrderMapper_003;
import com.itheima.mybatis.mapper.UserMapper_003;
import com.itheima.mybatis.pojo.Orders;
import com.itheima.mybatis.pojo.QueryVo;
import com.itheima.mybatis.pojo.User;

public class MybatisMapperTest_003 {
	@Test
	public void testMapperQueryVo() throws IOException{
		//加载核心配置文件
		String resource = "sqlMapConfig_003.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		UserMapper_003 userMapper_003 = sqlSession.getMapper(UserMapper_003.class);
		QueryVo vo = new QueryVo();
		User user = new User();
		user.setUsername("王彬");
		vo.setUser(user);
		List<User> users = userMapper_003.findUserByQueryVo(vo);
		for (User u : users) {
			System.out.println(u);
		}
	}

	@Test
	public void testMapperQueryVoCOunt() throws IOException{
		//加载核心配置文件
		String resource = "sqlMapConfig_003.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		UserMapper_003 userMapper_003 = sqlSession.getMapper(UserMapper_003.class);
		Integer count = userMapper_003.countUser();
		System.out.println(count);
	}

	@Test
	public void testOrderList() throws IOException{
		//加载核心配置文件
		String resource = "sqlMapConfig_003.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		OrderMapper_003 orderMapper_003 = sqlSession.getMapper(OrderMapper_003.class);
		List<Orders> orders = orderMapper_003.selectOrdersList();
		for (Orders order: orders) {
			System.out.println(order);
		}
	}

	@Test
	public void testFindUserBySexAndUsername() throws IOException{
		//加载核心配置文件
		String resource = "sqlMapConfig_003.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		UserMapper_003 userMapper_003 = sqlSession.getMapper(UserMapper_003.class);
		User user = new User();
		user.setSex("女");
		user.setUsername("王彬");
		List<User> users = userMapper_003.selectUserBySexAndUsername(user);
		for (User u : users) {
			System.out.println(u);
		}
	}

	@Test
	public void testSelectUserByIds() throws IOException{
		//加载核心配置问价
		String resource = "sqlMapConfig_003.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		UserMapper_003 userMapper_003 = sqlSession.getMapper(UserMapper_003.class);
		QueryVo vo = new QueryVo();
		List<Integer> list = new ArrayList<Integer>();
		list.add(32);
		list.add(33);
		list.add(34);
		list.add(35);
		vo.setIdsList(list);
		List<User> users = userMapper_003.selectUserByIds(vo);
		for (User u : users) {
			System.out.println(u);
		}
	}


	@Test
	public void testSelectOrders() throws IOException{
		//加载核心配置文件
		String resource="sqlMapConfig_003.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		OrderMapper_003 orderMapper_003 = sqlSession.getMapper(OrderMapper_003.class);
		List<Orders> orders = orderMapper_003.selectOrders();
		for (Orders o : orders) {
			System.out.println(o);
			System.out.println(o.getUser().getUsername());
		}

	}


	@Test
	public void testSelectUserList() throws IOException{

		//加载核心配置文件
		String resource = "sqlMapConfig_003.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		OrderMapper_003 orderMapper_003 = sqlSession.getMapper(OrderMapper_003.class);
		List<User> users = orderMapper_003.selectUserList();
		for (User user : users) {
			System.out.println(user);
			List<Orders> orders = user.getOrdersList();
			for (Orders order: orders) {
				System.out.println(order);
			}
		}
	}






























}



