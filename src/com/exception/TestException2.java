package com.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestException2 {

	public static void test() throws IOException {
		System.out.println(" --- > 3");
		FileInputStream fis = new FileInputStream("a.txt");
		System.out.println(" --- > 4");
	}

	public static void test2() throws FileNotFoundException {
		System.out.println(" --- > 3");
		FileInputStream fis = new FileInputStream("a.txt");
		System.out.println(" --- > 4");
	}

	public static void main(String[] args) {
		try {
			System.out.println(" --- > 1");
			test2();
			test();
		} catch (IOException e) {
			System.out.println(" --- > 2");
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (Exception e2) {
			System.out.println(" --- > 5");
			e2.printStackTrace();
		}
	}

}
