package com.cglib.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
* @ClassName: CGLibProxy
* @Description: CGLib������Դ���û���κνӿڵ��࣬����JDK��̬����ͬ
* @author BEE 
* @date 2016-3-30 ����2:24:10
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
