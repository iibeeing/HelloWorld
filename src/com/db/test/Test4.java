package com.db.test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.db.utils.ConnectionFactory;

public class Test4 {
	@Test
	public void test() {
		
		Connection conn = ConnectionFactory.getConnection();
		try {
			String sql_insert = " insert into td_account (id,username,total) values (?,?,?)";
			conn.setAutoCommit(false);
			/*conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			PreparedStatement pstm;
			pstm = conn.prepareStatement(sql_insert.toString());
			pstm.setInt(1,6);
			pstm.setString(2, "rose6");
			pstm.setDouble(3, 1000);
			int result = pstm.executeUpdate();
			System.out.println("新增操作影响行数 : " + result);*/
			PreparedStatement pstm;
			pstm = conn.prepareStatement(sql_insert.toString());
			for(int i=10;i<2000;i++){
				pstm.setInt(1,i);
				pstm.setString(2, "rose" + i);
				pstm.setDouble(3, i);
/*				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}*/
				int result = pstm.executeUpdate();
				System.out.println("第" + i + "次新增操作影响行数 : " + result);
			}
			
			
			//更新
			/*String sql_update = " update td_account set total = 6 where id = ?";
			pstm = conn.prepareStatement(sql_update.toString());
			pstm.setInt(1,3);
			result = pstm.executeUpdate();
			System.out.println("更新操作影响行数 : " + result);*/
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

}
