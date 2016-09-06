package com.httpServlet;

import javax.servlet.Servlet;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;
import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletProcessor {
	public void process(Request request, Response response) {
		if (request != null) {
			String uri = request.getUri();
			String servletName = uri.substring(uri.lastIndexOf("/") + 1);

			// 类加载器，用于从指定JAR文件或目录加载类
			URLClassLoader loader = null;
			try {
				URLStreamHandler streamHandler = null;
				// 创建类加载器
				loader = new URLClassLoader(new URL[] { new URL(null, "file:"
						+ Constants.WEB_SERVLET_ROOT, streamHandler) });
			} catch (IOException e) {
				System.out.println(e.toString());
			}

			Class<?> myClass = null;
			try {
				// 加载对应的servlet类
				myClass = loader.loadClass(servletName);
			} catch (ClassNotFoundException e) {
				System.out.println(e.toString());
			}

			Servlet servlet = null;
			// 给request、response增加外观类，安全性考虑，防止用户在servlet里直接将ServletRequest、ServletResponse向下转型为Request和Response类型，
			// 并直接调用其内部的public方法，因为RequestFacade、ResponseFacade里不会有parse、sendStaticResource等方法；
			RequestFacade requestFacade = new RequestFacade(request);
			ResponseFacade responseFacade = new ResponseFacade(response);
			try {
				// 生产servlet实例
				servlet = (Servlet) myClass.newInstance();
				// 执行ervlet的service方法
				//servlet.service((ServletRequest) request,(ServletResponse) response);
				servlet.service((ServletRequest) requestFacade, (ServletResponse) responseFacade);
			} catch (Exception e) {
				System.out.println(e.toString());
			} catch (Throwable e) {
				System.out.println(e.toString());
			}
		}

	}
}
