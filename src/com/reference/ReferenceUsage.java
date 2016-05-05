package com.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

import com.cglib.proxy.Person;

/**
 * Reference ��һ�������࣬�� SoftReference��WeakReference��PhantomReference �Լ� FinalReference ���Ǽ̳����ľ����ࡣ
 */
public class ReferenceUsage {
	public static void main(String[] args) {
		ReferenceQueue<String> refQueue = new ReferenceQueue<String>();
		// ��Ӧ��
		//�������޷�ͨ�� get() ������ȡ��Ŀ������ǿ���ôӶ�ʹ��Ŀ����󣬹۲�Դ����Է��� get() ����дΪ��Զ���� null��
		PhantomReference<String> referent = new PhantomReference<String>(new String("T"), refQueue);
		System.out.println(referent.get());// null
		System.gc();//����
		System.runFinalization();
		System.out.println(refQueue.poll() == referent); // true

		//�����ã���һ�ֻ��ղ�������գ���������������ȴû�л��գ�
		SoftReference<Person> bean = new SoftReference<Person>(new Person("�ܵ�ΰ"));
		System.out.println(bean.get());//��
		System.gc();//����
		System.runFinalization();
		System.out.println(bean.get());//��
		
		//�����ã��л��ղ����ͻ���
		WeakReference<Person> bean2 = new WeakReference<Person>(new Person("�ܵ�ΰ2"));
		System.out.println(bean2.get());//��
		System.gc();//����
		System.out.println(bean2.get());//null
		System.out.println(bean.get());//�� ----------------------------------------------------- ��bean2������Σ�beanӦ�ñ�������2�Σ�����������Ȼ�����ݣ��Ͳ������
		System.gc();//����
		System.out.println(bean.get());//������
	}
}
