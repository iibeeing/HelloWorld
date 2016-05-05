package com.proxy.dynamic.notinterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserDAOProxy implements InvocationHandler {
	
	private Object target;

	
	public UserDAOProxy(Object target){
		this.target = target;
	}
	
	public UserDAOProxy(){}
	
	public void setTarget(Object target) {
		this.target = target;
	}

	public void beforeMethod(Method m) {
		System.out.println(m.getName() + " start...");
	}

	public void afterMethod(Method m) {
		System.out.println(m.getName() + " end...");
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		beforeMethod(method);
		Object result = method.invoke(target, args);
		afterMethod(method);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getProxy(){
		return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
}
