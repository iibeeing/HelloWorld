package com.self;

import java.lang.reflect.Method;

public class MyTargetTest {

	@MyTarget
	public void doSomething(){
		System.out.println("hello World");
	}
	
	@MyTarget
	public void doSomething2(){
		System.out.println("hello World2");
	}
	
	public static void  main(String[] args) throws Exception{
		Method  method = MyTargetTest.class.getMethod("doSomething2",null);
		if(method.isAnnotationPresent(MyTarget.class)){
			System.out.println(method.getAnnotation(MyTarget.class));
		}
	}
}
