package com.lock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Calendar;

import com.factory.ConnectionFactory;

//-------------------------------
//MySql 默认隔离级别是 重复提交 （最高）
//SqlServer 默认隔离级别是 已提交读
//Oracle 默认隔离洁白是 已提交读
//-------------------------------


/**
@ClassName: LockDbTable
@Description: TODO(这里用一句话描述这个类的作用)
@author BEE 
@date 2016-5-13 上午11:35:38
 */
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
			// String sql = "select * from td_account where id=?";
			String sql = "select * from td_account";
			PreparedStatement pstm = conn.prepareStatement(sql.toString());
			// pstm.setObject(1, "2");
			ResultSet rs = pstm.executeQuery();
			boolean result = outputResultSet(rs);
			System.out.println("操作 " + (result == true ? "成功" : "失败"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void TestSelectRow(Connection conn) {
		try {
			// String sql = "select * from td_account where id=?";
			String sql = "select * from td_account where id = 2";
			PreparedStatement pstm = conn.prepareStatement(sql.toString());
			// pstm.setObject(1, "2");
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
			Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
			int hour = c.get(Calendar.HOUR_OF_DAY); 
			int minute = c.get(Calendar.MINUTE); 
			int second = c.get(Calendar.SECOND); 
			String time = hour + " : " + minute + " : " + second;
			pstm.setObject(1, time);
			pstm.setObject(2, "10000");
			int rs = pstm.executeUpdate();
			// TestSelect(conn);
			// conn.commit();
			System.out.println("TestInsert操作 " + (rs > 0 ? "成功" : "失败"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void TestUpdate(Connection conn) {
		try {
			conn.setAutoCommit(false);
			String sql = "update td_account set total = 0 where id = 1";
			PreparedStatement pstm = conn.prepareStatement(sql.toString());
			// pstm.setObject(1, "conn");
			// pstm.setObject(2, "10000");
			int rs = pstm.executeUpdate();
			// TestSelect(conn);
			// conn.commit();
			System.out.println("TestUpdate操作 " + (rs > 0 ? "成功" : "失败"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Connection conn = ConnectionFactory.getConnection();
		Connection conn2 = ConnectionFactory.getConnection();
		if (conn != null) {
			try {
				System.out.println("conn is " + conn.toString());
				System.out.println("conn2 is " + conn2.toString());
				// conn.setAutoCommit(false);
				// TestInsert(conn);
				// conn2.setAutoCommit(false);
				// TestInsert(conn2);

				System.out.println("事务 conn 的隔离级别 ->" + conn.getTransactionIsolation());
				System.out.println("事务 conn2 的隔离级别 ->" + conn2.getTransactionIsolation());
				/*
				//更改数据，事务提交之前，其他事务（注意隔离级别也是读未提交才行）对该行的所有（查询和更新）操作是可行的，就相当于无事务
				conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
				conn2.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
				*/
				
				
				/*//更改数据，事务提交之前，其他事务对该行的所有（查询和更新）操作是不行的，行级排他锁
				conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
				conn2.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);*/
				
				
				//当两个事务同时进行时，其中一个事务修改数据对另一个事务不会造成影响，即使修改的事务已经提交也不会对另一个事务造成影响。
				//　　在事务中对某条记录修改，会对记录加上行共享锁，直到事务结束才会释放。
				//相比TRANSACTION_READ_COMMITTED 级别，TRANSACTION_REPEATABLE_READ 增强了同时性，就是两个事务同时，一个事务在提交后，而另一
				//个事务还未提交，已提交事务对未提交事务无影响，已提交的事务即使修改或插入，但是未提交事务查询等操作的数据还是原来的数据，就像操作事务开始时的镜像
				conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
				conn2.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
				
				System.out.println("事务 conn 的隔离级别 ->" + conn.getTransactionIsolation());
				System.out.println("事务 conn2 的隔离级别 ->" + conn2.getTransactionIsolation());

				TestUpdate(conn);
				TestSelect(conn);
				TestInsert(conn);
				TestSelect(conn);
				TestInsert(conn2);
				TestSelectRow(conn2);
				// conn2.commit();
				// conn.commit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
