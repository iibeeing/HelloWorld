package com.db.utils;
public class DataAccessException extends RuntimeException {
	private static final long serialVersionUID = 5142890716814330858L;
	public DataAccessException(){
		super();
	}
	public DataAccessException(String message,Throwable cause){
		super(message,cause);
	}
	public DataAccessException(String message){
		super(message);
	}
	public DataAccessException(Throwable cause){
		super(cause);
	}
	
}
