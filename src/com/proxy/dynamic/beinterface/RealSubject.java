package com.proxy.dynamic.beinterface;

/**
 * ����ִ��������࣬ʵ���˴���ӿڡ�
 */
public class RealSubject implements Subject {

	/**
	 * ִ�и������ֵ����������ӡ����������������500msģ������ִ���˺ܳ�ʱ��
	 * 
	 * @param taskName
	 */
	@Override
	public void dealTask(String taskName) {
		System.out.println("����ִ������" + taskName);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}