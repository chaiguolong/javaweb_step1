package com.itheima.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest2_002 {

	public static void main(String[] args) {
		final Target target = new Target();

		//动态创建代理对象
		TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(
				target.getClass().getClassLoader(),
				target.getClass().getInterfaces(),
				new InvocationHandler(){
					@Override
					//被执行几次? ----看代理对象调用方法几次
					//代理对象调用接口相应方法 都是调用invoke
					/*
					   proxy:是代理对象
					   method:代表的是目标方法的字节码对象
					   args:代表是调用目标方法时参数
					*/
					public Object invoke(Object proxy,Method method,Object[] args) throws Throwable{
						//反射知识点
						Object invoke = method.invoke(target,args);//目标对象的相应方法
						//返回的值给代理对象
						return invoke;
					}
				}
			);
		proxy.method1();
		String method2 = proxy.method2();
		int method3 = proxy.method3(100);
	}

}
