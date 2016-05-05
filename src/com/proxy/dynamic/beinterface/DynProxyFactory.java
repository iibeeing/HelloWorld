package com.proxy.dynamic.beinterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * ���ɶ�̬�������Ĺ���.
 */
public class DynProxyFactory {
	// �ͻ�����ô˹���������ô������
	// �Կͻ�����˵���䲢��֪�����ص��Ǵ����������ί�������
	public static Subject getInstance() {
		Subject delegate = new RealSubject();
		InvocationHandler handler = new SubjectInvocationHandler(delegate);
		Subject proxy = null;
		proxy = (Subject) Proxy
				.newProxyInstance(delegate.getClass().getClassLoader(),
						delegate.getClass().getInterfaces(), handler);
		return proxy;
	}
}