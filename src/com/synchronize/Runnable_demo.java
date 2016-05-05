package com.synchronize;

public class Runnable_demo implements Runnable {
	private int ticket = 20;
	public Runnable_demo() {
	}

	/**
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param args 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable_demo demo = new Runnable_demo();
		// 基于火车票创建三个窗口
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
				// 休眠1s秒中，为了使效果更明显，否则可能出不了效果
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				this.sale();  
				//System.out.println(Thread.currentThread().getName() + "号窗口卖出："+ this.ticket-- + "号票");
			}

		}
	}

	public synchronized void sale(){
		if(this.ticket > 0){
			System.out.println(Thread.currentThread().getName() + "号窗口卖出："+ this.ticket-- + "号票");
		}
	}
	
}
