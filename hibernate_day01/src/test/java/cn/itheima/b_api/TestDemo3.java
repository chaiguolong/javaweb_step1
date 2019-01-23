package cn.itheima.b_api;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.itheima.domain.Customer;

//学习Session对象
//session对象功能: 表达hibernate框架与数据库之间的连接(会话).session类似于
//				JDBC年代的connection对象. 还可以完成对数据库中数据的增删改查操作.
//				session是hibernate操作数据库的核心对象
public class TestDemo3 {

	// @Test
	// //事务操作
	// public void fun1(){
	// 	Configuration conf = new Configuration().configure();
	// 	SessionFactory sessionFactory = conf.buildSessionFactory();
	// 	Session session = sessionFactory.openSession();
	// 	Transaction tx = session.beginTransaction();
	// 	//---------------------------------------------------
    //
    //
    //
	// 	//---------------------------------------------------
	// 	tx.commit();
	// 	tx.rollback();
	// 	session.close();
	// 	sessionFactory.close();
    //
	// }
	
	@Test
	//session的新增
	public void fun2(){
		Configuration conf = new Configuration().configure();
		SessionFactory sessionFactory = conf.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------

		Customer customer = new Customer();

		customer.setCust_name("腾讯");

		session.save(customer);
		

		//----------------------------------------------
		tx.commit();
		// tx.rollback();
		session.close();
		sessionFactory.close();
	}
	@Test
	//session的查询
	//查询id为3的customer对象
	public void fun3(){
		Configuration conf = new Configuration().configure();

		SessionFactory sessionFactory = conf.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		//----------------------------------------------

		Customer customer = session.get(Customer.class,3l);

		System.out.println(customer);

		//----------------------------------------------
		tx.commit();
		// tx.rollback();
		session.close();
		sessionFactory.close();


	}
	@Test
	//session的修改
	//修改id为3的customer对象的name属性为黑马程序员
	public void fun4(){
		Configuration conf = new Configuration().configure();
		SessionFactory sessionFactory = conf.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------

		Customer customer = session.get(Customer.class,8l);

		customer.setCust_name("黑子");

		session.update(customer);


		//----------------------------------------------
		tx.commit();
		session.close();
		sessionFactory.close();
	}
	@Test
	//session的删除
	//删除id为1的customer对象
	public void fun5(){
		Configuration conf = new Configuration().configure();
		SessionFactory sessionFactory = conf.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		//----------------------------------------------

		Customer customer = session.get(Customer.class,11l);

		session.delete(customer);


		//----------------------------------------------
		tx.commit();
		session.close();
		sessionFactory.close();

	}
}
