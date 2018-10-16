package com.ithiema.jedis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtils_002 {

	private static JedisPool pool = null;

	static{
		//加载配置文件
		InputStream in = JedisPoolUtils_002.class.getClassLoader().getResourceAsStream("redis.properties");
		Properties pro = new Properties();
		try {
			pro.load(in);
		} catch(Exception e){
			e.printStackTrace();
		}

		//获得池子对象
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxIdle(Integer.parseInt(pro.getProperty("redis.maxIdle")));//最大闲置数量
		poolConfig.setMinIdle(Integer.parseInt(pro.getProperty("redis.minIdle")));//最小闲置数量
		poolConfig.setMaxTotal(Integer.parseInt(pro.getProperty("redis.maxTotal")));//最大连接数
		pool = new JedisPool(poolConfig,pro.getProperty("redis.url"),Integer.parseInt(pro.getProperty("redis.port")));
	}

	//获得jedis资源的方法
	public static Jedis getJedis(){
		return pool.getResource();
	}

	public static void main(String[] args) {
		Jedis jedis = getJedis();
		System.out.println(jedis.get("xxx"));
	}




}
