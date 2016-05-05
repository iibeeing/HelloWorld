package com.proxy.dynamic.beinterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * ��̬�������Ӧ�ĵ��ô��������
 */
public class SubjectInvocationHandler implements InvocationHandler {

	// ���������һ��ί����Ķ�������
	private Object delegate;

	public SubjectInvocationHandler(Object delegate) {
		this.delegate = delegate;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		long stime = System.currentTimeMillis();
		// ���÷�����ƽ�������ɸ�ί���ദ��Method��invoke����Object������Ϊ����ִ�н����
		// ��Ϊʾ������û�з���ֵ��������������˷���ֵ����
		method.invoke(delegate, args);
		long ftime = System.currentTimeMillis();
		System.out.println("ִ�������ʱ" + (ftime - stime) + "����");
		return null;
	}
}