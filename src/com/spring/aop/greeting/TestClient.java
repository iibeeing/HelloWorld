package com.spring.aop.greeting;


import org.junit.Test;

public class TestClient {

	@Test
	public void test() {
/*		Greeting greetingProxy = new GreetingProxy(new GreetingImpl());
		greetingProxy.sayHello("JACK");
		
		Greeting greeting = new JDKDynamicProxy(new GreetingImpl()).getProxy();
		greeting.sayHello("Jack");
		
		Greeting greeting2 = CGLibDynamicProxy.getInstance().getProxy(GreetingImpl.class);
		greeting2.sayHello("jack");*/
		
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(new GreetingImpl());
		/*proxyFactory.addAdvice(new GreetingAfterAdvice());
		proxyFactory.addAdvice(new GreetingBeforeAdvice());*/
		proxyFactory.addAdvice(new GreetingAroundAdvice());
		Greeting greeting3 = (Greeting) proxyFactory.getProxy();
		greeting3.sayHello("jack jack");
	}

}
