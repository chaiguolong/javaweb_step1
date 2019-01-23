package com.itheima.mybatis.junit;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.junit.Test;

import com.itheima.mybatis.mapper.OrderMapper_001;
import com.itheima.mybatis.mapper.UserMapper_001;
import com.itheima.mybatis.pojo.Orders;
import com.itheima.mybatis.pojo.QueryVo;
import com.itheima.mybatis.pojo.User;

public class MybatisMapperTest_001 {
	@Test
	public void testMapperQueryVo() throws IOException{
		//加载核心配置文件
		String resource="sqlMapConfig_001.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		UserMapper_001 userMapper_001 = sqlSession.getMapper(UserMapper_001.class);
		QueryVo vo = new QueryVo();
		User user = new User();
		user.setUsername("五");
		vo.setUser(user);
		List<User> users = userMapper_001.findUserByQueryVo(vo);
		for (User u : users) {
			System.out.println(u);
		}
	}

	@Test
	public void testMapperQueryVoCOunt() throws IOException{
		//加载核心配置文件
		String resource = "sqlMapConfig_001.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		UserMapper_001 userMapper_001 = sqlSession.getMapper(UserMapper_001.class);
		Integer count = userMapper_001.countUser();
		System.out.println(count);
	}

	@Test
	public void testOrderList() throws IOException{
		//加载核心配置文件
		String resource = "sqlMapConfig_001.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		OrderMapper_001 orderMapper_001 = sqlSession.getMapper(OrderMapper_001.class);
		List<Orders> orders = orderMapper_001.selectOrdersList();
		for (Orders order : orders) {
			System.out.println(order);
		}
	}

	@Test
	public void testFindUserBySexAndUsername() throws IOException{
		//加载核心配置文件
		String resource = "sqlMapConfig_001.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		UserMapper_001 userMapper_001 = sqlSession.getMapper(UserMapper_001.class);
		User user = new User();
		user.setSex("男");
		user.setUsername("王斌");
		List<User> users = userMapper_001.selectUserBySexAndUsername(user);
		for (User u : users) {
			System.out.println(u);
		}
	}

	@Test
	public void testSelectUserByIds() throws IOException{
		//加载核心配置文件
		String resource = "sqlMapConfig_001.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建Sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		UserMapper_001 userMapper_001 = sqlSession.getMapper(UserMapper_001.class);
		QueryVo vo = new QueryVo();
		List<Integer> list = new ArrayList<Integer>();
		list.add(32);
		list.add(33);
		list.add(34);
		list.add(35);
		vo.setIdsList(list);
		List<User> users = userMapper_001.selectUserByIds(vo);
		for (User u : users) {
			System.out.println(u);
		}
	}

	@Test
	public void testSelectOrders() throws IOException{
		//加载核心配置文件
		String resource = "sqlMapConfig_001.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		OrderMapper_001 orderMapper_001 = sqlSession.getMapper(OrderMapper_001.class);
		List<Orders> orders = orderMapper_001.selectOrders();
		for (Orders o: orders) {
			System.out.println(o);
			System.out.println(o.getUser().getUsername());
		}
	}

	@Test
	public void testSelectUserList() throws IOException{
		//加载核心配置文件
		String resource = "sqlMapConfig_001.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建sqlSessionfactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		OrderMapper_001 orderMapper_001 = sqlSession.getMapper(OrderMapper_001.class);
		List<User> users = orderMapper_001.selectUserList();
		for (User u : users) {
			System.out.println(u);
			List<Orders> orders = u.getOrdersList();
			for (Orders o: orders) {
				System.out.println(o.getNumber());
				System.out.println(o.getId());
			}
		}

	}
































}
