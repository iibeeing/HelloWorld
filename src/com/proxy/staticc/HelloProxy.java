package com.proxy.staticc;

public class HelloProxy implements Hello {

	private Hello hello;

	public HelloProxy() {
		hello = new HelloImpl();
	}

	@Override
	public void sayHello(String name) {
		before();
		hello.sayHello(name);
		after();
	}

	private void after() {
		System.out.println("after");
	}

	private void before() {
		System.out.println("before");
	}

}
