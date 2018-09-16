package com.itheima.proxy;

public class Target_001 implements TargetInterface_001{



	@Override
	public void method1() {
		System.out.println("method1 running...");
	}

	@Override
	public String method2() {
		System.out.println("method2 running ...");
		return "method2";
	}

	@Override
	public int method3(int i) {
		return i;
	}
}
