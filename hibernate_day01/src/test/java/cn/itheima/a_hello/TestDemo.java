package cn.itheima.a_hello;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.junit.Test;

import cn.itheima.domain.Customer;

public class TestDemo{
	@Test
	public void fun1(){
		Configuration conf = new Configuration().configure();

		SessionFactory sessionFactory = conf.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		//=================================================

		Customer c = new Customer();

		c.setCust_name("阿里巴巴");

		session.save(c);

		//=================================================
		tx.commit();
		sessionFactory.close();


	}
}
