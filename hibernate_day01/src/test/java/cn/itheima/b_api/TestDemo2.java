package cn.itheima.b_api;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.itheima.domain.Customer;

//学习SessionFactory对象
// SessionFactory功能: 用于创建操作数据库核心对象session对象的工厂.
//					 简单说功能就一个---创建session对象
//注意:1.sessionfactory 负责保存和使用所有配置信息.消耗内存资源非常大.
//	  2.sessionFactory属于线程安全的对象设计.
//结论: 保证在web项目中,只创建一个sessionFactory.
public class TestDemo2 {

	// @Test
	// public void fun1(){
	// 	Configuration conf = new Configuration();
    //
	// 	SessionFactory sessionFactory = conf.buildSessionFactory();
    //
	// 	Session session = sessionFactory.openSession();
    //
	// 	sessionFactory.getCurrentSession();
	// }
}
