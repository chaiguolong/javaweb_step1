package com.itheima.mybatis.junit;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.junit.Test;

import com.itheima.mybatis.mapper.OrderMapper;
import com.itheima.mybatis.mapper.OrderMapper_002;
import com.itheima.mybatis.mapper.UserMapper;
import com.itheima.mybatis.pojo.Orders;
import com.itheima.mybatis.pojo.User;

public class MybatisMapperTest2 {


	@Test
	public void testOrderList() throws Exception {
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//SqlSEssion帮我生成一个实现类  （给接口）
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<Orders> selectOrdersList = orderMapper.selectOrders();
		
		for (Orders orders : selectOrdersList) {
			System.out.println(orders);
		}
	}
	@Test
	public void testUserList() throws Exception {
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//SqlSEssion帮我生成一个实现类  （给接口）
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<User> users = orderMapper.selectUserList();
		for (User user : users) {
			System.out.println(user);
		}
		
	}
	
	@Test
	public void testSelectUserList() throws IOException{
		//加载核心配置文件
		String resource = "sqlMapConfig_002.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		OrderMapper_002 orderMapper_002 = sqlSession.getMapper(OrderMapper_002.class);
		List<User> users = orderMapper_002.selectUserList();
		for (User u : users) {
			System.out.println(u);
			List<Orders> orders = u.getOrdersList();
			for (Orders order  : orders) {
				System.out.println(order);
			}
		}
	}




























}
