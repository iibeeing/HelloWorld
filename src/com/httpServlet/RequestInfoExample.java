package com.httpServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestInfoExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RequestInfoExample() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("＜html＞");
		out.println("＜body＞");
		out.println("＜head＞");
		out.println("＜title＞Request Information Example＜/title＞");
		out.println("＜/head＞");
		out.println("＜body＞");
		out.println("＜h3＞Request Information Example＜/h3＞");
		out.println("Method: " + request.getMethod());
		out.println("Request URI: " + request.getRequestURI());
		out.println("Protocol: " + request.getProtocol());
		out.println("PathInf " + request.getPathInfo());
		out.println("Remote Address: " + request.getRemoteAddr());
		out.println("＜/body＞");
		out.println("＜/html＞");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
