package com.spring.aop.greeting;

public class GreetingImpl implements Greeting {

	@Override
	public void sayHello(String name) {
		//before();
		System.out.println("Hello ! " + name);
		//after();
	}

/*	private void after() {
		System.out.println("after ! ");
		
	}

	private void before() {
		System.out.println("before ! ");
		
	}
*/
}
