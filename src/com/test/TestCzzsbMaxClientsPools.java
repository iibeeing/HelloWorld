package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
public class TestCzzsbMaxClientsPools {

	/**
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param args 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public static void main(String[] args) {
		String sqlstr = "SELECT top 10 * from t_student_info";
		sqlData sqldata = new sqlData();
		sqldata.executeQuery(sqlstr);
		sqldata.sqlclose();
	}
}

class sqlData {
	// 在此使用自己的IP 地址和端口号
	String url = "jdbc:sqlserver://10.30.215.171:1433;DatabaseName=CZZSBBM";
	String login = "sa"; // 用户名
	String password = "cccccc"; // 密码
	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public Connection connection = null;
	public Statement st = null;
	public ResultSet rs = null;
	public ResultSetMetaData m=null;//获取 列信息

	public sqlData() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.setLoginTimeout(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sqlclose() {
		try {
			st.close();
			connection.close();
		} catch (SQLException e) {
			System.err.println("sqlclose: " + e.getMessage());
		}
	}

	public ResultSet executeQuery(String sql) {
		try {
			connection = DriverManager.getConnection(url, login, password);
			st = connection.createStatement();
			rs = st.executeQuery(sql);
			m=rs.getMetaData();
			for(int i=1;i<=13;i++)
			   {
			    System.out.print(m.getColumnName(i));
			    System.out.print("\t\t");
			   }
			//int columns=m.getColumnCount();
			System.out.println();
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- ");
			while(rs.next()){
				for(int i=1;i<=13;i++){
					System.out.print(rs.getString(i));
					System.out.print("\t\t");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			System.err.println("aq.executeQuery: " + e.getMessage());
		}
		return rs;
	}
}

