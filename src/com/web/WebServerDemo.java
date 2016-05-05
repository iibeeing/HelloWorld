package com.web;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;

import com.test.TestCzzsbMaxClients;

public class WebServerDemo {

	/**
	 * @Title: main
	 * @Description: TODO(������һ�仰�����������������)
	 * @param @param args �趨�ļ�
	 * @return void ��������
	 * @throws
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * while(true){ try { ServerSocket ss = new ServerSocket(10000); Socket
		 * s = ss.accept(); byte[] bytes = new byte[1024]; int len = 0;
		 * InputStream is = s.getInputStream(); len = is.read(bytes);
		 * System.out.println("��ȡ���ֽ�����" + len); System.out.println(new
		 * String(bytes)); Thread thread = Thread.currentThread();
		 * System.out.println("��ǰ�̣߳� " + thread.getId()); // �������д������
		 * OutputStream os = s.getOutputStream(); String str =
		 * "<h1 style='color:red'>����,�������</h1><h1>��ǰ�߳��ǣ�" + thread.getId()
		 * +"<h1>"; os.write(str.getBytes()); s.close(); ss.close(); } catch
		 * (Exception e) { e.printStackTrace(); } }
		 */
		int i = 0;
		String s = "�̣߳�";
		while (true) {
			try {
				i++;
				ThreadDemo demo = new ThreadDemo(i, i);
				demo.start();
				System.out.println("��ǰ�ǣ� " + i);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static class ThreadDemo extends Thread {
		
		private int id = 0;
		private long s = 0;

		public ThreadDemo(int id, long s) {
			this.id = id;
			this.s = s;
		}

		@Override
		public void run() {
			try {
				ServerSocket ss = new ServerSocket(10000);
				Socket s = ss.accept();
				byte[] bytes = new byte[1024];
				int len = 0;
				InputStream is = s.getInputStream();
				len = is.read(bytes);
				System.out.println("��ȡ���ֽ�����" + len);
				System.out.println(new String(bytes));
				Thread thread = Thread.currentThread();
				System.out.println("��ǰ�̣߳� " + thread.getId());
				// �������д������
				OutputStream os = s.getOutputStream();
				String str = "<h1 style='color:red'>����,�������</h1><h1>��ǰ�߳��ǣ�"
						+ thread.getId() + "<h1>";
				os.write(str.getBytes());
				s.close();
				ss.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
