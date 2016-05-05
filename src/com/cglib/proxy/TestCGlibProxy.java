package com.cglib.proxy;
import org.junit.Test;

import com.proxy.staticc.HelloImpl;

public class TestCGlibProxy {
	@Test
	public void test() {
		CGLibProxy cgLibProxy = new CGLibProxy();
		HelloImpl helloProxy = cgLibProxy.getProxy(HelloImpl.class);
		helloProxy.sayHello("Jack");
		
		//Person ��ô��ʵ�ֽӿڣ�Ҳ û�д���ʲô�ӿڣ�Ҳ��ʵ�ִ���
		Person person = cgLibProxy.getProxy(Person.class);
		person.sayChinese();
		
		Person english = CGLibProxySington.getInstance().getProxy(Person.class);
		english.sayEnglish();
	}

}
