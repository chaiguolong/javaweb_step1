package com.itheima.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.itheima.mybatis.pojo.User;

/**
 * 原始Dao开发
 * @author lx
 *
 */
public class UserDaoImpl implements UserDao{
	private SqlSessionFactory sqlSessionFactory;

	// public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
	// 	this.sqlSessionFactory = sqlSessionFactory;
	// }

	@Override
	public User findUserById(Integer id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("userDao.selectUserById",id);
		return user;
	}


	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
