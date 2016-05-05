package com.cglib.proxy;
import org.junit.Test;

import com.proxy.staticc.HelloImpl;

public class TestCGlibProxy {
	@Test
	public void test() {
		CGLibProxy cgLibProxy = new CGLibProxy();
		HelloImpl helloProxy = cgLibProxy.getProxy(HelloImpl.class);
		helloProxy.sayHello("Jack");
		
		//Person 类么有实现接口，也 没有传递什么接口，也可实现代理
		Person person = cgLibProxy.getProxy(Person.class);
		person.sayChinese();
		
		Person english = CGLibProxySington.getInstance().getProxy(Person.class);
		english.sayEnglish();
	}

}
