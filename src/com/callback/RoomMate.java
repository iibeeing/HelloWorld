package com.callback;

import java.util.concurrent.TimeUnit;

public class RoomMate {
	public void getAnswer(String homework, DoHomeWork someone) {
		if ("1+1=?".equals(homework)) {
			someone.doHomeWork(homework, "2");
		} else if ("��x������0��sin(x)/x =?".equals(homework)) {
			System.out.print("˼����");
			for (int i = 1; i <= 3; i++) {
				System.out.print(i + "�� ");
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println();
			someone.doHomeWork(homework, "1");
		} else {
			someone.doHomeWork(homework, "(�հ�)");
		}
	}
}
