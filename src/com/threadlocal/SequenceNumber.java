package com.threadlocal;
/**
@ClassName: SequenceNumber
@Description: 该用例说明ThreadLocal来存储每个线程的局部变量，
下面的seqNum 就是 SequenceNumber类实例的变量，各个实例之间seqNum是独立的
@author BEE 
@date 2016-5-5 下午4:30:07
 */
public class SequenceNumber {

	private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){
		public Integer initialValue(){
			return 0;
		}
	};
	
	public int getNextNum(){
		seqNum.set(seqNum.get() + 1);
		return seqNum.get();
	}
	
	public int get(){
		return seqNum.get();
	}
	
	public static void main(String[] args) {
		
		SequenceNumber sn = new SequenceNumber();
		TestClient t1 = new TestClient(sn);
		TestClient t2 = new TestClient(sn);
		TestClient t3 = new TestClient(sn);
		
		t1.start();
		t2.start();
		t3.start();
	}
	
	private static class TestClient extends Thread{
		private SequenceNumber sn;
		
		public TestClient(SequenceNumber sn){
			this.sn = sn;
		}
		
		@Override
		public void run() {
			System.out.println("ID -> " + Thread.currentThread().getId() + " NAME -> " + Thread.currentThread().getName() + " seqNum -> " + sn.seqNum.get());
			sn.seqNum.set((int)Thread.currentThread().getId());
			System.out.println("ID -> " + Thread.currentThread().getId() + " NAME -> " + Thread.currentThread().getName() + " seqNum -> " + sn.seqNum.get());
			//System.out.println("thread[" + Thread.currentThread().getName() + "] sn[" + sn.getNextNum() + "]");
		}
	}

}
