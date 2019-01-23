package cn.itheima.b_api;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.itheima.domain.Customer;

//学习Configuration对象
// Configuration功能: 配置加载类.用于加载主配置,orm元数据加载
public class TestDemo {

	@Test
	public void fun1(){
		Configuration conf = new Configuration();
		conf.configure();

		SessionFactory SessionFactory = conf.buildSessionFactory();
		
	}
}
