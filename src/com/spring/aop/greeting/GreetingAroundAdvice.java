package com.spring.aop.greeting;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class GreetingAroundAdvice implements MethodInterceptor {

	private void before() {
		System.out.println("Before");
	}

	private void after() {
		System.out.println("After");
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		before();
		Object object = invocation.proceed();
		after();
		return object;
	}
}
