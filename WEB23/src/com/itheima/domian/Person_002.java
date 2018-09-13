package com.itheima.domian;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Person_002 implements HttpSessionBindingListener{
	private String id;
	private String name;

	@Override
	//绑定的方法
	public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
		System.out.println("person被绑定了");
	}

	@Override
	//解绑的方法
	public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
		System.out.println("person被解绑了");
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
