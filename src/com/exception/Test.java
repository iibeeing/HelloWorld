package com.exception;

public class Test {
	static int quotient(int x, int y) throws MyException { // 定义方法抛出异常
		if (y < 0) { // 判断参数是否小于0
			throw new MyException("除数不能是负数"); // 异常信息
		}
		return x / y; // 返回值
	}

	static int quotient2(int x, int y)throws Exception{
		if (y < 0) { // 判断参数是否小于0
			//这里抛出的是Exception，那么就会获取Exception异常，
			//一般就可以把自定义的异常放在这里，来抛出自定义的异常
			throw new Exception("除数不能是负数"); // 异常信息
			//
			//throw new MyException("除数不能是负数"); // 异常信息
		}
		return x / y; // 返回值
	}
	
	public static void main(String args[]) { // 主方法
		int a = 3;
		int b = -1;
		try { // try语句包含可能发生异常的语句
			int result = quotient2(a, b); // 调用方法quotient()
		} catch (MyException e) { // 处理自定义异常
			System.out.println(e.getMessage()); // 输出异常信息
		} catch (ArithmeticException e) { // 处理ArithmeticException异常
			System.out.println("除数不能为0"); // 输出提示信息
		} catch (Exception e) { // 处理其他异常
			System.out.println("程序发生了其他的异常"); // 输出提示信息
		}
	}

}

class MyException extends Exception { // 创建自定义异常类
	String message; // 定义String类型变量

	public MyException(String ErrorMessagr) { // 父类方法
		message = ErrorMessagr;
	}

	public String getMessage() { // 覆盖getMessage()方法
		return message;
	}
}