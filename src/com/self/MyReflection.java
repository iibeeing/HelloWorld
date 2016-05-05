package com.self;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import com.self.MyTest;

public class MyReflection {
	public static void main(String[] args) throws Exception {
		MyTest myTest = new MyTest();
		Class<MyTest> c = MyTest.class;
		Method method = c.getMethod("output", new Class[] {});
		// 如果MyTest类名上有注解@MyAnnotation修饰，则为true
		if (MyTest.class.isAnnotationPresent(MyAnnotation.class)) {
			System.out.println("have annotation");
		}
		if (method.isAnnotationPresent(MyAnnotation.class)) {
			Object obj = method.invoke(myTest, null); // 调用output方法
			// 获取方法上注解@MyAnnotation的信息
			MyAnnotation myAnnotation = method
					.getAnnotation(MyAnnotation.class);
			String hello = myAnnotation.hello();
			String world = myAnnotation.world();
			System.out.println(hello + ", " + world);// 打印属性hello和world的值
			System.out.println(myAnnotation.array().length);// 打印属性array数组的长度
			System.out.println(myAnnotation.lannotation().value()); // 打印属性lannotation的值
			System.out.println(myAnnotation.style());
		}
		// 得到output方法上的所有注解，当然是被RetentionPolicy.RUNTIME修饰的
		Annotation[] annotations = method.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println(annotation.annotationType().getName());
		}
	}
}
