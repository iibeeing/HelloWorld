package com.eventdelegation;

import java.lang.reflect.Method;   

public class Event {
	// Ҫִ�з����Ķ���
	private Object object;
	// Ҫִ�еķ�������
	private String methodName;
	// Ҫִ�з����Ĳ���
	private Object[] params;
	// Ҫִ�з����Ĳ�������
	@SuppressWarnings("rawtypes")
	private Class[] paramTypes;

	public Event() {}

	public Event(Object object, String methodName, Object... args) {
		this.object = object;
		this.methodName = methodName;
		this.params = args;
		contractParamTypes(this.params);
	}

	// ���ݲ����������ɲ�����������
	private void contractParamTypes(Object[] params) {
		this.paramTypes = new Class[params.length];
		for (int i = 0; i < params.length; i++) {
			this.paramTypes[i] = params[i].getClass();
		}
	}

	public Object getObject() {
		return object;
	}

	// ����setter getterʡ��
//	public void setParamTypes(Class[] paramTypes) {
//		this.paramTypes = paramTypes;
//	}

	// ִ�и� ����ĸ÷���
	public void invoke() throws Exception {
		Class clazz = object.getClass();
		String name = this.getMethodName();
		Class[] parameterTypes = this.getParamTypes();
		Method method =clazz.getMethod(name, parameterTypes);
		//Method method = object.getClass().getMethod(this.getMethodName(),this.getParamTypes());
		if (null == method) {
			return;
		}
		method.invoke(this.getObject(), this.getParams());
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Object[] getParams() {
		return params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}

	@SuppressWarnings("rawtypes")
	public Class[] getParamTypes() {
		return paramTypes;
	}

	public void setParamTypes(@SuppressWarnings("rawtypes") Class[] paramTypes) {
		this.paramTypes = paramTypes;
	}

	public void setObject(Object object) {
		this.object = object;
	}
	
	
}
