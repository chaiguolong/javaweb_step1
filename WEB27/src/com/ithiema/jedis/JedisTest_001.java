package com.ithiema.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisTest_001 {

	//通过Java程序访问redis数据库

	@Test
	//获得单一的jedis对象操作数据库
	public void test1(){
		//1.获得连接对象
		Jedis jedis = new Jedis("10.211.55.37",6379);

		//2.获得数据
		String username = jedis.get("username");
		System.out.println(username);

		//3.存储
		jedis.set("addr","上海");
		System.out.println(jedis.get("addr"));
	}

	//通过jedis的pool获得jedis连接对象
	@Test
	public void test2(){
		//0.创建池子的配置对象
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxIdle(30);//最大的闲置个数
		poolConfig.setMinIdle(10);//最小的闲置个数
		poolConfig.setMaxTotal(50);//最大的连接数


		//1.创建一个redis的连接池
		JedisPool pool = new JedisPool(poolConfig ,"10.211.55.37",6379);
		
		//2.从池子中获取redis的连接资源
		Jedis jedis = pool.getResource();

		//3.操作数据库
		jedis.set("xxx","hahahha");
		System.out.println(jedis.get("xxx"));

		//4.关闭资源
		jedis.close();
		pool.close();

	}

}
