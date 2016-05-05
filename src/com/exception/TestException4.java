package com.exception;

public class TestException4 extends Exception {
	/**
	* @ClassName: AuctionException
	* @Description: �Զ����쳣�����ڴ���ĳһ���쳣���
	* @author BEE 
	* @date 2016-3-22 ����2:59:58
	 */
	public class AuctionException extends Exception {
		//���캯��������Ҫ
		public AuctionException() {
		};

		//���ι��캯��������Ҫ
		public AuctionException(String message) {
			super(message);
		};
	}

	// ����AuctionException����쳣���Զ�����쳣��
	private double initPrice = 30.0;

	public void bid(String bidPrice) throws AuctionException {
		double d = 0.0;
		try {
			d = Double.parseDouble(bidPrice);
		} catch (Exception e) {
			e.printStackTrace();
			//System.err.println(e.getMessage());
			throw new AuctionException("���ļ۱�������ֵ�����ܰ��������ַ���");
		}
		if (initPrice > d) {
			throw new AuctionException("���ļ۱����ļ۵ͣ��������ģ�");
		}
		initPrice = d;
	}

	public static void main(String[] args) {
		TestException4 ta = new TestException4();
		try {
			//����Ƿ���ֵ���쳣
			//ta.bid("df");
			//�����С�ڳ�ʼֵ��initPrice�����쳣
			ta.bid("1");
		} catch (AuctionException ae) {
			System.err.println(ae.getMessage());
		}
	}
}
