package com.itheima.domian;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Person_001 implements HttpSessionBindingListener{
	private String id;
	private String name;

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
		System.out.println("Person被绑定了");
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
		System.out.println("Person被解绑了");
	}
}
