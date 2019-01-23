package cn.itheima.a_generator;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.itheima.domain.Customer;
import cn.itheima.utils.HibernateUtils;



public class TestDemo {
	public void TestFun1(){
		//1.打开session
		Session session = HibernateUtils.openSession();
		//2.开启事务
		Transaction tx = session.beginTransaction();
		//3.保存数据
		Customer customer = new Customer();
		customer.setCust_name("国家电网");
		session.save(customer);
		//4.提交事务
		tx.commit();
		//5.关闭资源
		session.close();
	}
}



