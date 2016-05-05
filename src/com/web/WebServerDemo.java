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
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param args 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * while(true){ try { ServerSocket ss = new ServerSocket(10000); Socket
		 * s = ss.accept(); byte[] bytes = new byte[1024]; int len = 0;
		 * InputStream is = s.getInputStream(); len = is.read(bytes);
		 * System.out.println("读取得字节数：" + len); System.out.println(new
		 * String(bytes)); Thread thread = Thread.currentThread();
		 * System.out.println("当前线程： " + thread.getId()); // 向浏览器写入内容
		 * OutputStream os = s.getOutputStream(); String str =
		 * "<h1 style='color:red'>您好,浏览器！</h1><h1>当前线程是：" + thread.getId()
		 * +"<h1>"; os.write(str.getBytes()); s.close(); ss.close(); } catch
		 * (Exception e) { e.printStackTrace(); } }
		 */
		int i = 0;
		String s = "线程：";
		while (true) {
			try {
				i++;
				ThreadDemo demo = new ThreadDemo(i, i);
				demo.start();
				System.out.println("当前是： " + i);
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
				System.out.println("读取得字节数：" + len);
				System.out.println(new String(bytes));
				Thread thread = Thread.currentThread();
				System.out.println("当前线程： " + thread.getId());
				// 向浏览器写入内容
				OutputStream os = s.getOutputStream();
				String str = "<h1 style='color:red'>您好,浏览器！</h1><h1>当前线程是："
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
