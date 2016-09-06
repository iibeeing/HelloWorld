package com.httpServlet;

import java.io.OutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Locale;
import javax.servlet.ServletResponse;
import javax.servlet.ServletOutputStream;

public class Response implements ServletResponse {

	private static final int BUFFER_SIZE = 1024;
	Request request;
	OutputStream output;
	PrintWriter writer;

	public Response(OutputStream output) {
		this.output = output;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	/**
	@Description: 将web文件写入到OutputStream字节流中
	@param @throws IOException    设定文件
	@date 创建时间：2016-9-6 下午2:37:31 
	 */
	public void sendStaticResource() throws IOException {
		byte[] bytes = new byte[BUFFER_SIZE];
		FileInputStream fis = null;
		try {
			/* request.getUri has been replaced by request.getRequestURI */
			if(request != null && request.getUri() != null){
				File file = new File(Constants.WEB_ROOT, request.getUri());
				fis = new FileInputStream(file);
				int ch = fis.read(bytes, 0, BUFFER_SIZE);
				while (ch != -1) {
					output.write(bytes, 0, ch);
					ch = fis.read(bytes, 0, BUFFER_SIZE);
				}
			}
		} catch (FileNotFoundException e) {
			String errorMessage = "HTTP/1.1 404 File Not Found\r\n"
					+ "Content-Type: text/html\r\n" + "Content-Length: 23\r\n"
					+ "\r\n" + "<h1>File Not Found</h1>";
			output.write(errorMessage.getBytes());
		} finally {
			if (fis != null)
				fis.close();
		}
	}

	/** implementation of ServletResponse */
	public void flushBuffer() throws IOException {
	}

	public int getBufferSize() {
		return 0;
	}

	public String getCharacterEncoding() {
		return null;
	}

	public Locale getLocale() {
		return null;
	}

	public ServletOutputStream getOutputStream() throws IOException {
		return null;
	}

	public PrintWriter getWriter() throws IOException {
		writer = new PrintWriter(output, true);
		return writer;
	}

	public boolean isCommitted() {
		return false;
	}

	public void reset() {
	}

	public void resetBuffer() {
	}

	public void setBufferSize(int size) {
	}

	public void setContentLength(int length) {
	}

	public void setContentType(String type) {
	}

	public void setLocale(Locale locale) {
	}

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	public void setCharacterEncoding(String arg0) {
		
	}
}
