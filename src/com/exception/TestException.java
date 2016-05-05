package com.exception;

import java.io.FileInputStream;
import java.io.IOException;

public class TestException {
	public static int testExceptionCase() {
		try {
			FileInputStream fis = new FileInputStream("a.txt");
			System.out.println("1 - 》fis 执行完");
			int i = 5 / 0;
			System.out.println("2 - 》i执行完");
			return 1;
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			System.out.println("3 - 》IOException执行完");
			ioe.printStackTrace();
			return 2;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("4 - 》Exception执行完");
			e.printStackTrace();
			return 3;
		} finally {
			System.out.println("5 - 》finally执行完");
			return 4;
		}
	}

	/**
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param args 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public static void main(String[] args) {
		try {
			System.out.println("testExceptionCase output " + testExceptionCase());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("m4 - 》Exception执行完");
			e.printStackTrace();
			return;
		} finally {
			System.out.println("m5 - 》finally执行完");
		}

	}

}
