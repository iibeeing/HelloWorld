package com.synchronize;

public class Runnable_demo implements Runnable {
	private int ticket = 20;
	public Runnable_demo() {
	}

	/**
	 * @Title: main
	 * @Description: TODO(������һ�仰�����������������)
	 * @param @param args �趨�ļ�
	 * @return void ��������
	 * @throws
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable_demo demo = new Runnable_demo();
		// ���ڻ�Ʊ������������
		new Thread(demo, "a").start();
		new Thread(demo, "b").start();
		new Thread(demo, "c").start();
		new Thread(demo, "d").start();
		new Thread(demo, "e").start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 20; i++) {
			if (this.ticket > 0) {
				// ����1s���У�Ϊ��ʹЧ�������ԣ�������ܳ�����Ч��
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				this.sale();  
				//System.out.println(Thread.currentThread().getName() + "�Ŵ���������"+ this.ticket-- + "��Ʊ");
			}

		}
	}

	public synchronized void sale(){
		if(this.ticket > 0){
			System.out.println(Thread.currentThread().getName() + "�Ŵ���������"+ this.ticket-- + "��Ʊ");
		}
	}
	
}
