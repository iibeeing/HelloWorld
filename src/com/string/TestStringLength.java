package com.string;

public class TestStringLength {

	/**
	 * @Title: main
	 * @Description: TODO(������һ�仰�����������������)
	 * @param @param args    �趨�ļ�
	 * @return void    ��������
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
				System.out.println( " ��ʱ���� " + i);
			}catch (Exception e) {
				System.out.println(e.getMessage() + " ��ʱ���� " + i);
			}
		}
	}

}
