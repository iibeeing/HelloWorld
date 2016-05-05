package com.callback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Student implements DoHomeWork {
private static final Logger logger = LoggerFactory.getLogger(Student.class);
	
	
	@Override
	public void doHomeWork(String question, String answer) {
		System.out.println("��ҵ��");
		if (answer != null) {
			System.out.println("��ҵ��" + question + " �𰸣�" + answer);
		} else {
			System.out.println("��ҵ��" + question + " �𰸣�" + "(�հ�)");
		}
	}

	/**
	* @Title: ask
	* @Description: #�¿����̴߳��������ȴ���������д�����á������ں���������������3��ĵȴ�ʱ�䣬
	* ���Կ��Կ���goHome��������ִ�С� #��ζ�Ÿ�ѧ���ڸ�֪�����������ú󣬾Ϳ������Լ�������ȥ�ˣ�
	* ����Ҫͬ������ȥ�ȴ������ #һ��������������ã�д����ҵ�������ֳ�Ҳ�ͽ��������ˡ�
	* @param @param homework
	* @param @param roomMate    �趨�ļ�
	* @return void    ��������
	* @throws
	 */
	public void ask(final String homework, final RoomMate roomMate) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				roomMate.getAnswer(homework, Student.this);
			}
		}).start();
		goHome();
	}

	public void goHome() {
		System.out.println("�һؼ��ˡ��������ѣ�����д����ҵ��");
/*		logger.info("�һؼ��ˡ��������ѣ�����д����ҵ��");
		logger.debug("�һؼ��ˡ��������ѣ�����д����ҵ��");
		logger.error("�һؼ��ˡ��������ѣ�����д����ҵ��");
		logger.trace("�һؼ��ˡ��������ѣ�����д����ҵ��");
		logger.warn("�һؼ��ˡ��������ѣ�����д����ҵ��");*/
	}

	public static void main(String[] args) {
/*		RoomMate roomMate = new RoomMate();
		roomMate.getAnswer("1+1=?", new DoHomeWork() {
			@Override
			public void doHomeWork(String question, String answer) {
				System.out.println("���⣺" + question + " �𰸣�" + answer);
			}
		});*/
		Student student = new Student();
	    String homework = "��x������0��sin(x)/x =?";
	    student.ask(homework, new RoomMate());
	}

}
