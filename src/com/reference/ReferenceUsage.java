package com.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

import com.cglib.proxy.Person;

/**
 * Reference 是一个抽象类，而 SoftReference，WeakReference，PhantomReference 以及 FinalReference 都是继承它的具体类。
 */
public class ReferenceUsage {
	public static void main(String[] args) {
		ReferenceQueue<String> refQueue = new ReferenceQueue<String>();
		// 虚应用
		//虚引用无法通过 get() 方法来取得目标对象的强引用从而使用目标对象，观察源码可以发现 get() 被重写为永远返回 null。
		PhantomReference<String> referent = new PhantomReference<String>(new String("T"), refQueue);
		System.out.println(referent.get());// null
		System.gc();//回收
		System.runFinalization();
		System.out.println(refQueue.poll() == referent); // true

		//软引用，下一轮回收操作后回收，不过本代码例子却没有回收，
		SoftReference<Person> bean = new SoftReference<Person>(new Person("熊德伟"));
		System.out.println(bean.get());//有
		System.gc();//回收
		System.runFinalization();
		System.out.println(bean.get());//有
		
		//弱引用，有回收操作就回收
		WeakReference<Person> bean2 = new WeakReference<Person>(new Person("熊德伟2"));
		System.out.println(bean2.get());//有
		System.gc();//回收
		System.out.println(bean2.get());//null
		System.out.println(bean.get());//有 ----------------------------------------------------- 在bean2回收这次，bean应该被回收了2次，但是这里仍然有数据，就不理解了
		System.gc();//回收
		System.out.println(bean.get());//还是有
	}
}
