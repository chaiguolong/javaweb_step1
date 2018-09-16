package com.itheima.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;
public class ProxyTest_001 {
	@SuppressWarnings(value={"unchecked","rawtypes"})
	public void test1(){
		//获得动态的代理对象---在运行时 在内存中动态的为Target创建一个虚拟的代理对象
		//objProxy是代理对象 根据参数确定到底是谁的代理对象
		TargetInterface_001 objProxy = (TargetInterface_001) Proxy.newProxyInstance(
				Target_001.class.getClassLoader(),
				new Class[]{TargetInterface_001.class},
				new InvocationHandler(){
					//invoke 代表的是执行代理对象的方法
					@Override
					//mothod:代表目标对象的方法字节码对象
					//args:代表目标对象的响应的方法的参数
					public Object invoke(Object proxy,Method method,Object[] args) throws Throwable{
						System.out.println("目标方法前的逻辑");
						//执行目标对象的方法
						Object invoke = method.invoke(new Target_001(),args);
						System.out.println("目标方法后的逻辑");
						return invoke;
					}
				}
			);

		objProxy.method1();
		String method2 = objProxy.method2();
		System.out.println(method2);

	}
}
