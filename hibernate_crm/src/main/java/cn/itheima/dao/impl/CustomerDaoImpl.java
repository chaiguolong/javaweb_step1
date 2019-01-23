package cn.itheima.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.itheima.dao.CustomerDao;
import cn.itheima.domain.Customer;
import cn.itheima.utils.HibernateUtils;

public class CustomerDaoImpl implements CustomerDao{
	public void save(Customer customer){
	//1.打开session
	Session session = HibernateUtils.openSession();
	//2.开启事务
	Transaction tx = session.beginTransaction();
	//3.保存客户
	session.save(customer);
	//4.提交事务
	tx.commit();
	//5.关闭资源
	session.close();
	}
}



