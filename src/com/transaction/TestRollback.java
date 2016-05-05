/**   
* @Title: TestRollback.java 
* @Package com.transaction 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Bee
* @date 2016-3-18 下午2:50:11 
* @version V1.0   
*/ 
package com.transaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.factory.ConnectionFactory;

/**   
 * 类名称：TestRollback   
 * 类描述：   
 * 创建人：Bee   
 * 创建时间：2016-3-18 下午2:50:11   
 * 修改人：Bee   
 * 修改时间：2016-3-18 下午2:50:11   
 * 修改备注：   
 * @version    
 */
public class TestRollback {

	@Test
	public void test() {
		//fail("Not yet implemented");
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try{
			con = ConnectionFactory.getConnection();
			//设置手动提交
			con.setAutoCommit(false);
			StringBuffer sql = new StringBuffer();
			sql.append(" select total ");
			sql.append(" from td_account ");
			sql.append(" where username = ? ;");
			pstm = con.prepareStatement(sql.toString());
			pstm.setString(1, "jack");
			rs = pstm.executeQuery();
			System.out.println(sql.toString());
			int total = 0;
			if(rs.next()){
				total = rs.getInt("total");
			}
			if(total > 8000){
				StringBuffer updateA = new StringBuffer();
				updateA.append(" update td_account ");
				updateA.append(" set total = total - ? ");
				updateA.append(" where username = ? ;");
				pstm = con.prepareStatement(updateA.toString());
				pstm.setInt(1, 8000);
				pstm.setString(2, "jack");
				System.out.println(updateA.toString());
				int isUpdate1 = pstm.executeUpdate();
				
				if(isUpdate1 > 0){
					System.out.println("jack 账户扣款成功，交易结束 ............................");
					StringBuffer updateB = new StringBuffer();
					updateB.append(" update td_account ");
					updateB.append(" set total = total + ? ");
					updateB.append(" where username = ? ;");
					//int n = 1/0;
					pstm = con.prepareStatement(updateB.toString());
					pstm.setInt(1, 8000);
					pstm.setString(2, "mary");
					int isUpdate2 = pstm.executeUpdate();
					System.out.println(updateB.toString());
					if(isUpdate2 > 0){
						System.out.println("mary 账户收到汇款，交易结束 ............................");
					}else{
						System.out.println("mary 账户转账未成功.............................");
					}
				}else{
					System.out.println("jack 账户转账未成功.............................");
				}
			}else{
				System.out.println(" 余额不足，交易取消............................");
			}
			con.commit();
		}catch (Exception e) {
			e.printStackTrace();
			try{
				System.out.println(" 交易失败，操作回滚............................");
				con.rollback();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		finally{
			ConnectionFactory.close(con, pstm, rs);
		}
	}
}
