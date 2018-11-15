package com.itheima.domian;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class Customer_002 implements HttpSessionActivationListener,Serializable{
	private static final long serialVersionUID = -345341231532346L;

	private String id;

	private String name;


	@Override
	public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {
		System.out.println("customer被激活了");
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
		System.out.println("customer被钝化了");
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
