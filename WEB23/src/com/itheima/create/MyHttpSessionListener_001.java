package com.itheima.create;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener_001 implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
		System.out.println("session创建"+httpSessionEvent.getSession().getId());;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
		System.out.println("session销毁");
	}
}

