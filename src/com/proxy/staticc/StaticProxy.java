package com.proxy.staticc;
import org.junit.Test;

public class StaticProxy {

	@Test
	public void test() {
		Hello helloProxy = new HelloProxy();
		helloProxy.sayHello("Jack");
	}

}
