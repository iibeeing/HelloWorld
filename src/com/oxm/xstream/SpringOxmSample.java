package com.oxm.xstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

import com.oxm.domain.LoginLog;
import com.oxm.domain.User;

public class SpringOxmSample {
	private Marshaller marshaller;
	private Unmarshaller unmarshaller;

	/*
	 * private static XStream xstream;
	 * 
	 * static { xstream = new XStream(new DomDriver()); }
	 */

	public User getUser() {
		/*
		 * LoginLog log1 = new LoginLog(); log1.setIp("192.168.1.91");
		 * log1.setLongDate(new Date());
		 * 
		 * User user = new User(); user.setUserId(1);
		 * user.setUserName("xstream"); user.addLoginLog(log1); return user;
		 */
		LoginLog log1 = new LoginLog();
		log1.setIp("192.168.1.91");
		log1.setLoginDate(new Date());
		LoginLog log2 = new LoginLog();
		log2.setIp("192.168.1.92");
		log2.setLoginDate(new Date());
		LoginLog log3 = new LoginLog();
		log3.setIp("192.168.1.93");
		log3.setLoginDate(new Date());
		User user = new User();
		user.setUserName("spring-oxm");
		user.addLoginLog(log1);
		user.addLoginLog(log2);
		user.addLoginLog(log3);
		return user;
	}

	/*
	 * public static void objectToXML() throws Exception { User user =
	 * getUser(); FileOutputStream outputStream = new
	 * FileOutputStream("D:\\XStreamSample.xml"); xstream.toXML(user,
	 * outputStream); }
	 * 
	 * public static void XMLToObject() throws Exception { FileInputStream
	 * inputStream = new FileInputStream("D:\\XStreamSample.xml"); User user =
	 * (User) xstream.fromXML(inputStream); for (LoginLog log : user.getLogs())
	 * { if (log != null) { System.out.println("访问IP： " + log.getIp());
	 * System.out.println("访问时间： " + log.getLongDate()); } } }
	 * 
	 * public static void main(String[] args) { System.out.println("开始"); try {
	 * objectToXML(); XMLToObject(); } catch (Exception e) {
	 * e.printStackTrace(); } System.out.println("结束"); }
	 */
	/**
	 * JAVA对象转化为XML
	 */
	public void objectToXml() throws Exception {
		User user = getUser();
		FileOutputStream os = null;
		try {
			os = new FileOutputStream(
					"D:\\XStreamSample.xml");
			this.marshaller.marshal(user, new StreamResult(os));
		} finally {
			if (os != null) {
				os.close();
			}
		}
	}

	/**
	 * XML转化为JAVA对象
	 */
	public void xmlToObject() throws Exception {
		FileInputStream is = null;
		User u = null;
		try {
			is = new FileInputStream(
					"D:\\XStreamSample.xml");
			u = (User) this.unmarshaller.unmarshal(new StreamSource(is));
		} finally {
			if (is != null) {
				is.close();
			}
		}
		for (LoginLog log : u.getLogs()) {
			if (log != null) {
				System.out.println("访问IP: " + log.getIp());
				System.out.println("访问时间: " + log.getLoginDate());
			}
		}

	}

	public static void main(String[] args) throws Exception {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:/config/applicationContext.xml");
		SpringOxmSample oxm = (SpringOxmSample) appContext.getBean("springOxm");
		oxm.objectToXml();
		oxm.xmlToObject();
	}

	public void setMarshaller(Marshaller marshaller) {
		this.marshaller = marshaller;
	}

	public void setUnmarshaller(Unmarshaller unmarshaller) {
		this.unmarshaller = unmarshaller;
	}
}
