package com.db.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionFactory {
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/e001";
	private static final String USER = "root";
	private static final String PASSWORD = "cccccc";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	public static void close(Connection conn,Statement stm,ResultSet rs){
		try{
			if(rs != null) rs.close();
			if(stm != null) stm.close();
			if(conn != null) conn.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		// TODO Auto-generated method stub
		try{
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL,USER,PASSWORD);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
