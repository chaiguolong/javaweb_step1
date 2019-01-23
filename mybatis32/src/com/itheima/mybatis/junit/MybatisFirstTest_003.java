package com.itheima.mybatis.junit;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.junit.Test;

import com.itheima.mybatis.pojo.User;

public class MybatisFirstTest_003 {
	@Test
	public void testMybatis() throws Exception{
		//加载核心配置文件
		String resource = "sqlMapConfig_003.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//执行sql语句
		User user = sqlSession.selectOne("test.findUserById",10);
		System.out.println(user);
	}
	//根据用户名模糊查询用户
	@Test
	public void testFindUserByUsername() throws Exception{
		//加载核心配置文件
		String resource = "sqlMapConfig_003.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//执行sql语句
		List<User> users = sqlSession.selectList("test.findUserByUsername","五");

		for (User user : users) {
			System.out.println(user);
		}
	}
	//增加用户
	@Test
	public void testInsertUser() throws Exception{
		//加载核心配置文件
		String resource = "sqlMapConfig_003.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql
		User user = new User();
		user.setUsername("王彬");
		user.setBirthday(new Date());
		user.setAddress("四川");
		user.setSex("女");
		int num = sqlSession.insert("test.insertUser",user);
		sqlSession.commit();
		System.out.println(user.getId());
	}
	//更新用户
	@Test
	public void testUpdateUserById() throws Exception{
		//加载核心配置文件
		String resource = "sqlMapConfig_003.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		User user = new User();
		// | 32 | 何炅      | 2019-01-17 | 男   | sdfsds       |
		user.setId(32);
		user.setUsername("王鹏");
		user.setBirthday(new Date());
		user.setAddress("大西北");
		user.setSex("女");
		sqlSession.update("test.updateUserById",user);
		sqlSession.commit();
	}

	//删除用户
	@Test
	public void testName() throws Exception{
		//加载核心配置文件
		String resource = "sqlMapConfig_003.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		sqlSession.delete("test.deleteUserById",42);
		sqlSession.commit();
	}

}



