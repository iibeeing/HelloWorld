package com.exception;

public class TestException4 extends Exception {
	/**
	* @ClassName: AuctionException
	* @Description: 自定义异常，用于处理某一类异常情况
	* @author BEE 
	* @date 2016-3-22 下午2:59:58
	 */
	public class AuctionException extends Exception {
		//构造函数，必须要
		public AuctionException() {
		};

		//带参构造函数，必须要
		public AuctionException(String message) {
			super(message);
		};
	}

	// 以下AuctionException这个异常是自定义的异常类
	private double initPrice = 30.0;

	public void bid(String bidPrice) throws AuctionException {
		double d = 0.0;
		try {
			d = Double.parseDouble(bidPrice);
		} catch (Exception e) {
			e.printStackTrace();
			//System.err.println(e.getMessage());
			throw new AuctionException("竞拍价必须是数值，不能包含其他字符！");
		}
		if (initPrice > d) {
			throw new AuctionException("竞拍价比起拍价低，不允许竞拍！");
		}
		initPrice = d;
	}

	public static void main(String[] args) {
		TestException4 ta = new TestException4();
		try {
			//这个是非数值的异常
			//ta.bid("df");
			//这个是小于初始值（initPrice）的异常
			ta.bid("1");
		} catch (AuctionException ae) {
			System.err.println(ae.getMessage());
		}
	}
}
