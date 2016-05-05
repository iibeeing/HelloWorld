package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	/**
	 * @Title: main
	 * @Description: TODO(������һ�仰�����������������)
	 * @param @param args    �趨�ļ�
	 * @return void    ��������
	 * @throws
	 */
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] { "Spring-Customer.xml" });
		CustomerService cust = (CustomerService) appContext.getBean("customerService");
		System.out.println("*************************");
		cust.printName();
		System.out.println("*************************");
		cust.printURL();
		System.out.println("*************************");
		try {
			cust.printThrowException();
		} catch (Exception e) {

		}

	}

}
