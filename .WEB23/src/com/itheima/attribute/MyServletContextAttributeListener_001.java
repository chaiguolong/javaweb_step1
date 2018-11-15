package com.itheima.attribute;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MyServletContextAttributeListener_001 implements ServletContextAttributeListener{

	@Override
	public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
		System.out.println("-----------------------------------------");
		//放到域中的属性
		System.out.println(servletContextAttributeEvent.getName());//放到域中的name
		System.out.println(servletContextAttributeEvent.getValue());//放到域中的value
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
		System.out.println(servletContextAttributeEvent.getName());//删除域中name
		System.out.println(servletContextAttributeEvent.getValue());//删除域中的value
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
		System.out.println(servletContextAttributeEvent.getName());//获得修改前的name
		System.out.println(servletContextAttributeEvent.getValue());//获得修改前的value
	}
}

