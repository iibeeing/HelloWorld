package com.web;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class JavaWebService {
	 public static void main(String arg[]) throws Exception
	    {
	        ServerSocket server=new ServerSocket(9999);
	        System.out.println("等待连接.....");
	        Socket socket=server.accept();
	        OutputStream outStream=socket.getOutputStream();
	        System.out.println("连接成功.....");
	        BufferedReader bufferReader=new BufferedReader(new FileReader("D:\\index.html"));
	        String buf="";
	        while((buf=bufferReader.readLine())!=null)
	        {
	            outStream.write(buf.getBytes());            
	        }
	        bufferReader.close();
	        outStream.close();
	        socket.close();
	        
	    }
}
