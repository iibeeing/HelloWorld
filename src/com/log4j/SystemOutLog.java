package com.log4j;

import org.apache.log4j.Logger;

public class SystemOutLog {
	static {
		Log4jPrintStream.redirectSystemOut();
	}

	public static Logger logger = Logger.getLogger(SystemOutLog.class);  
	
	public static void main(String[] args) {
/*		for (int i = 0; i < 10; i++) {
			System.out.print("abc");
			System.out.print(i);
			System.out.print((char) (i + 0X21));
		}*/
		logger.info("测试log4j");
		
        System.out.print("zhujiadun");  
        System.out.print("在测试log4j配置stdout");
        try{
        	int n = 10 / 0;
        	System.out.print("n is " + n);
        }catch (Exception e) {
        	e.printStackTrace();
        	System.out.print("e is " + e.getMessage());
        	System.out.println("ln e is " + e.getMessage());
		}
        
	}
}
