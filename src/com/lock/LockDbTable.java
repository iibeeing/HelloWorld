package com.lock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.transaction.TransactionManager;

import com.factory.ConnectionFactory;

public class LockDbTable {

	private static boolean outputResultSet(ResultSet rs) {
		boolean result = false;
		try {
			ResultSetMetaData m = rs.getMetaData();
			int columns = m.getColumnCount();
			// 显示列,表格的表头
			for (int i = 1; i <= columns; i++) {
				System.out.print(m.getColumnName(i));
				System.out.print("\t\t");
			}
			System.out.println();
			// 显示表格内容
			while (rs.next()) {
				for (int i = 1; i <= columns; i++) {
					System.out.print(rs.getString(i));
					System.out.print("\t\t");
				}
				System.out.println();
			}
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	public static void TestSelect(Connection conn) {
		try {
			String sql = "select * from td_account where id=?";
			PreparedStatement pstm = conn.prepareStatement(sql.toString());
			pstm.setObject(1, "2");
			ResultSet rs = pstm.executeQuery();
			boolean result = outputResultSet(rs);
			System.out.println("操作 " + (result == true ? "成功" : "失败"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void TestInsert(Connection conn) {
		try {
			conn.setAutoCommit(false);
			String sql = "insert into td_account (username,total) values(?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql.toString());
			pstm.setObject(1, "conn");
			pstm.setObject(2, "10000");
			int rs = pstm.executeUpdate();
			
			TestSelect(conn);
			
			//conn.commit();
			System.out.println("操作 " + (rs > 0 ? "成功" : "失败"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	public static void main(String[] args) {
		Connection conn = ConnectionFactory.getConnection();
		if (conn != null) {
//			TestSelect(conn);
			TestInsert(conn);
		}
	}
}
