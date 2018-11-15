package com.itheima.domian;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class Customer_001 implements HttpSessionActivationListener,Serializable{
	private static final long serialVersionUID = -345341231532346L;

	private String id;
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}


	@Override
	//钝化
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("customer被钝化了");
	}
	@Override
	//活化
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("customer被活化了");
	}



	

}
