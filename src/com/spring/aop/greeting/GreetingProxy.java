package com.spring.aop.greeting;

public class GreetingProxy implements Greeting {

	private GreetingImpl greetingImpl;
	
	public GreetingProxy(GreetingImpl greetingImpl){
		this.greetingImpl = greetingImpl;
	}
	@Override
	public void sayHello(String name) {
		before();
		greetingImpl.sayHello(name);
		after();
	}
	private void after() {
		System.out.println("after ! ");
		
	}

	private void before() {
		System.out.println("before ! ");
		
	}

}
