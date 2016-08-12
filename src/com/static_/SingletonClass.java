package com.static_;

/**
 * 单例模式
@ClassName: SingletonClass
 */
public class SingletonClass {
	private static SingletonClass instance = null;

    public static SingletonClass getInstance() {
        if (instance == null) {
        	//这是正确的 为空检查和实例化是一个“事务”，同时运行，CPU不能暂停
             synchronized (SingletonClass.class) {
                  if (instance == null) {
                      instance = new SingletonClass();
                  }
             }
             //这是错误的，假如线程A到了1步，被CPU暂停，运行线程B也到1步，结果线程A走，实例化一次，然后线程B走，也实例化
/*             if (instance == null) {                    //1步
                  instance = new SingletonClass(); //2步
             }*/
        }
        return instance;
    }

	private SingletonClass() {
	}
}
