package com.db.mysql.pool;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

/**
* @ClassName: TestDbcp
* @Description: 测试Dbcp连接池，该连接池遵循先进先出原理，比如
* con1.close()先关闭，则如果要新创建一个，则新创建的是con1连接(堆栈)
* @author BEE 
* @date 2016-3-16 下午2:21:23
 */
public class TestDbcp {
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl("jdbc:mysql://127.0.0.1:3306/test");
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("cccccc");
		ds.setMaxActive(4);
		ds.setMaxIdle(2);
		ds.setMaxWait(5000);

		Connection con1 = ds.getConnection();
		System.out.println("con1 - > " + con1);
		Connection con2 = ds.getConnection();
		System.out.println("con2 - > " + con2);
		Connection con3 = ds.getConnection();
		System.out.println("con3 - > " + con3);
		con1.close();
		con2.close();
		con3.close();
		System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  ");
		Connection con4 = ds.getConnection();
		System.out.println("con4 - > " + con4);
		Connection con5 = ds.getConnection();
		System.out.println("con5 - > " + con5);
		Connection con6 = ds.getConnection();
		System.out.println("con6 - > " + con6);
		con4.close();
		con5.close();
		con6.close();
	}

}
