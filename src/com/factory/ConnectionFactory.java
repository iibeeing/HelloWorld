/**   
* @Title: ConnectionFactory.java 
* @Package com.factory 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author Bee
* @date 2016-3-18 ����2:55:40 
* @version V1.0   
*/ 
package com.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**   
 * �����ƣ�ConnectionFactory   
 * ��������   
 * �����ˣ�Bee   
 * ����ʱ�䣺2016-3-18 ����2:55:40   
 * �޸��ˣ�Bee   
 * �޸�ʱ�䣺2016-3-18 ����2:55:40   
 * �޸ı�ע��   
 * @version    
 */
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
