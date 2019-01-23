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

public class MybatisFirstTest_002 {
	@Test
	public void testMybatis() throws Exception{
		//加载核心配置文件
		String resource = "sqlMapConfig_002.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//执行sql语句
		User user = sqlSession.selectOne("test.findUserById",10);
		System.out.println(user);

	}
	//根据用户名模糊查找用户
	@Test
	public void testFindUserByUsername() throws Exception{
		//加载核心配置文件
		String resource = "sqlMapConfig_002.xml";
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
		String resource = "sqlMapConfig_002.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		User user = new User();
		user.setUsername("范伟");
		user.setBirthday(new Date());
		user.setAddress("黑龙江");
		user.setSex("女");
		int num = sqlSession.insert("test.insertUser",user);
		sqlSession.commit();

		System.out.println(user.getId());
	}

	//更新用户
	@Test
	public void testUpdateUserById() throws Exception{
		//加载核心配置文件
		String resource = "sqlMapConfig_002.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		User user = new User();
		// | 33 | 何炅     | 2019-01-17 | 男   | sdfsds  |
		user.setId(33);
		user.setUsername("李志");
		user.setBirthday(new Date());
		user.setAddress("新疆");
		user.setSex("男");
		sqlSession.update("test.updateUserById",user);
		sqlSession.commit();
	}
	
	//删除用户
	@Test
	public void testDelete() throws Exception{
		//加载核心配置文件
		String resource = "sqlMapConfig_002.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行sql语句
		sqlSession.delete("test.deleteUserById",43);
		sqlSession.commit();
	}
}



