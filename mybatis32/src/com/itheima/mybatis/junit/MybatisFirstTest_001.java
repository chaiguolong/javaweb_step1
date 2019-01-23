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

public class MybatisFirstTest_001 {

	@Test
	public void testMybatis() throws Exception{

		//加载核心配置文件
		String resource = "sqlMapConfig_001.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//执行sql语句
		User user = sqlSession.selectOne("test.findUserById",10);

		System.out.println(user);
		
	}
	//根据用户名称模糊查询用户列表
	@Test
	public void testfindUserByUsername() throws Exception{
		//加载核心配置文件
		String resource = "sqlMapConfig_001.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		List<User> list = sqlSession.selectList("test.findUserByUsername","五");

		for (User user : list) {
			System.out.println(user);
		}

	}

	//添加用户
	@Test
	public void testInsertUser() throws Exception{
		//加载核心配置文件
		String resource = "sqlMapConfig_001.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//执行sql语句
		User user = new User();
		user.setUsername("何炅");
		user.setBirthday(new Date());
		user.setAddress("sdfsds");
		user.setSex("男");
		int num = sqlSession.insert("test.insertUser",user);
		sqlSession.commit();

		System.out.println(user.getId());

	}

	//更新用户
	@Test
	public void testUpdateUserById() throws Exception{
		//加载核心配置文件
		String resource = "sqlMapConfig_001.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		User user = new User();
		// | 35 | 王彬     | 2019-01-17 | 女   | 四川    |
		user.setId(35);
		user.setUsername("王斌");
		user.setBirthday(new Date());
		user.setAddress("海南");
		user.setSex("男");
		sqlSession.update("test.updateUserById",user);
		sqlSession.commit();

	}

	//删除用户
	@Test
	public void testDelete() throws Exception{
		//加载核心配置文件
		String resource = "sqlMapConfig_001.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		sqlSession.delete("test.deleteUserById",45);
		sqlSession.commit();
	}
}



