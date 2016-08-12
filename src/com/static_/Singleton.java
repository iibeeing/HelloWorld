package com.static_;

//对第一行static的一些解释
//java允许我们在一个类里面定义静态类。比如内部类（nested class）。
//把nested class封闭起来的类叫外部类。
//在java中，我们不能用static修饰顶级类（top level class）。
//只有内部类可以为static。
public class Singleton {
	// 在自己内部定义自己的一个实例，只供内部调用
	private static final Singleton instance = new Singleton();

	private Singleton() {
		// do something
	}

	// 这里提供了一个供外部访问本class的静态方法，可以直接访问
	public static Singleton getInstance() {
		return instance;
	}
}