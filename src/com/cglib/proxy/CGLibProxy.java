package com.cglib.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
* @ClassName: CGLibProxy
* @Description: CGLib代理可以代理没有任何接口的类，这点跟JDK动态代理不同
* @author BEE 
* @date 2016-3-30 下午2:24:10
 */
public class CGLibProxy implements MethodInterceptor {

	@Override
	public Object intercept(Object obj, Method method, Object[] args,MethodProxy proxy) throws Throwable {
		before();
		Object result = proxy.invokeSuper(obj, args);
		after();
		return result;
	}

	private void after() {
		System.out.println("CGLibProxy ------------ > after()");
	}

	private void before() {
		System.out.println("CGLibProxy ------------ > before()");
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getProxy(Class<T> cls){
		return (T) Enhancer.create(cls, this);
	}
}
