package com.exception;

import java.io.FileInputStream;
import java.io.IOException;

public class TestException {
	public static int testExceptionCase() {
		try {
			FileInputStream fis = new FileInputStream("a.txt");
			System.out.println("1 - ��fis ִ����");
			int i = 5 / 0;
			System.out.println("2 - ��iִ����");
			return 1;
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			System.out.println("3 - ��IOExceptionִ����");
			ioe.printStackTrace();
			return 2;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("4 - ��Exceptionִ����");
			e.printStackTrace();
			return 3;
		} finally {
			System.out.println("5 - ��finallyִ����");
			return 4;
		}
	}

	/**
	 * @Title: main
	 * @Description: TODO(������һ�仰�����������������)
	 * @param @param args �趨�ļ�
	 * @return void ��������
	 * @throws
	 */
	public static void main(String[] args) {
		try {
			System.out.println("testExceptionCase output " + testExceptionCase());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("m4 - ��Exceptionִ����");
			e.printStackTrace();
			return;
		} finally {
			System.out.println("m5 - ��finallyִ����");
		}

	}

}
