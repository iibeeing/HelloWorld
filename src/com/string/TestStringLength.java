package com.string;

public class TestStringLength {

	/**
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param args    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String v = "";
		int i=0;
		while(true){
			try{
				v += "50023419860301441X,";
				v += "50023419860301441X,";
				v += v;
				i++;
				System.out.println( " 当时长度 " + i);
			}catch (Exception e) {
				System.out.println(e.getMessage() + " 当时长度 " + i);
			}
		}
	}

}
