package com.spring.aop.greeting;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//import net.sf.cglib.proxy.Enhancer;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
//import org.springframework.cglib.proxy.InvocationHandler;

//import sun.reflect.MethodAccessor;

public class ProxyFactory implements InvocationHandler {
	private Object target;
	private MethodBeforeAdvice before;
	private AfterReturningAdvice after;
	private IBeforeAndAfter advice;
	private MethodInterceptor methodInterceptor;
	
	private Object obj;
	
	
	public ProxyFactory() {
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public void addAdvice(MethodBeforeAdvice before) {
		this.before = before;
	}

	public void addAdvice(IBeforeAndAfter advice) {
		this.advice = advice;
	}

	public void addAdvice(AfterReturningAdvice after) {
		this.after = after;
	}

	public void addAdvice(MethodInterceptor methodInterceptor) {
		this.methodInterceptor = methodInterceptor;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//before.before(method, args, null);
		//Object obj = method.invoke(target, args);
		//after.afterReturning(method, method, args, null);
/*		Class cls = obj.
		Object obj = cls.newInstance();*/
		methodInterceptor.invoke(method);
		System.out.println("obj -- > " + obj);
		Object obj2 = method.invoke(target, args);
		System.out.println("obj2 -- > " + obj2);
		return obj2;
	}

	@SuppressWarnings("unchecked")
	public <T> T getProxy() {
		return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), this);
	}
}
